package com.heavymaverick.spring.cnlogistic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "static/index";
    }

    @GetMapping("/price")
    public String price() {
        return "price_count";
    }
}
