package com.heavymaverick.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<Student>();
    public void addStudent() {
        Student st1 = new Student("Alexey Alexeev", 4, 7.5);
        Student st2 = new Student("Mihail Borunov", 2, 8.3);
        Student st3 = new Student("Elena Pelena", 1, 9.1);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }
    public List<Student> getStudents() {
        System.out.println("Начало работы метода getStudents");
        System.out.println(students.get(3));
        System.out.println("Students in University");
        System.out.println(students);
        return students;
    }
}
