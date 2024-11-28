package com.heavymaverick;

import org.apache.logging.log4j.message.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TasksRestControllerTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    MessageSource messageSource;

    @InjectMocks
    TasksRestController controller;

    @Test
    @DisplayName("GET /api/tasks возвращает HTTP-ответ со статусом 200 OK и списком задач")
    void handleGetAllTasksTest_ReturnsValidResponseEntity() {
        // given
        var tasks = List.of(new Task(UUID.randomUUID(), "Первая задача", false),
                new Task(UUID.randomUUID(), "Вторая задача", true));
        doReturn(tasks).when(taskRepository).findAll();
        // when
        var responseEntity = controller.handleGetAllTasks();

        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(tasks, responseEntity.getBody());
    }

    @Test
    void handleCreateNewTask_PayloadIsValid_ReturnsValidResponseEntity() {
        // given
        var details = "Третья задача";
        // when
        var responseEntity = controller.handleCreateNewTask(new NewTaskPayload(details),
                UriComponentsBuilder.fromUriString("http://localhost:8080"), Locale.ENGLISH);

        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        if (responseEntity.getBody() instanceof Task task) {
            assertNotNull(task.id());
            assertEquals(details, task.details());
            assertFalse(task.completed());

            assertEquals(URI.create("http://localhost:8080/api/tasks/" + task.id()),
                    responseEntity.getHeaders().getLocation());
            verify(taskRepository).save(task);
        } else {
            assertInstanceOf(Task.class, responseEntity.getBody());
        }

        verifyNoMoreInteractions(taskRepository);
    }

    @Test
    void handleCreateNewTask_PayloadIsInvalid_ReturnsValidResponseEntity() {
        // given
        var details = "   ";
        var locale = Locale.US;
        var errorMessage = "Details is empty";
        doReturn(errorMessage).when(messageSource)
                .getMessage("tasks.create.details.errors.not_set", new Object[0], locale);

        //when
        var responseEntity = controller.handleCreateNewTask(new NewTaskPayload(details),
                UriComponentsBuilder.fromUriString("http://localhost:8080"), locale);

        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(new ErrorsPresentation(List.of(errorMessage)), responseEntity.getBody());

        verifyNoInteractions(taskRepository);

    }

}