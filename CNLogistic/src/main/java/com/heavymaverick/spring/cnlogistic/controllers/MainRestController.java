package com.heavymaverick.spring.cnlogistic.controllers;

import com.heavymaverick.spring.cnlogistic.models.OrderModel;
import com.heavymaverick.spring.cnlogistic.repositories.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainRestController {
    private final RequestRepository requestRepository;

    @PostMapping("/orders")
    public ResponseEntity<String> addOrder(@RequestBody OrderModel order) {
        requestRepository.save(order);
        return new ResponseEntity<>("Order created", HttpStatus.CREATED);
    }
}
