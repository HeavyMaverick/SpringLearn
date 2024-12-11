package com.heavymaverick.spring.cnlogistic.controllers;

import com.heavymaverick.spring.cnlogistic.dto.OrderDTO;
import com.heavymaverick.spring.cnlogistic.repositories.OrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping("/price")
    public ResponseEntity<String> addOrder(Model model, @Valid @ModelAttribute OrderDTO order, BindingResult bindingResult) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO.setUsername(order.getUsername());
            orderDTO.setAmountCny(order.getAmountCny());
            orderDTO.setTotalCost(order.getTotalCost());
            orderRepository.save(order);
        } catch (Exception e) {
            bindingResult.addError(new FieldError("orderDTO", "username", e.getMessage()));
        }
        return ResponseEntity.ok("Заказ создан");
    }
}
