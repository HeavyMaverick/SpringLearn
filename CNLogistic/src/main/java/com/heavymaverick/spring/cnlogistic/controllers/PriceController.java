package com.heavymaverick.spring.cnlogistic.controllers;

import com.heavymaverick.spring.cnlogistic.models.OrderModel;
import com.heavymaverick.spring.cnlogistic.repositories.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PriceController {
    private final RequestRepository requestRepository;

    @GetMapping("/requests/{username}")
    public String findRequests(@PathVariable String username, Model model){
        List<OrderModel> orders = requestRepository.findAllByUsername(username);
        model.addAttribute("orders", orders);
        return "requests";
    }
}
