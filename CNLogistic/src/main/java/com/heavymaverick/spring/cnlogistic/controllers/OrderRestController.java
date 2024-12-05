package com.heavymaverick.spring.cnlogistic.controllers;

import com.heavymaverick.spring.cnlogistic.models.OrderModel;
import com.heavymaverick.spring.cnlogistic.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderRepository orderRepository;

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestBody OrderModel order) {
        try {
            orderRepository.save(order);
            return new ResponseEntity<>("Заказ создан", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Произошла ошибка при создании заказа",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
