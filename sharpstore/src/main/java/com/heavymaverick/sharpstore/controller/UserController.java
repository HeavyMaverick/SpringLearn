package com.heavymaverick.sharpstore.controller;

import com.heavymaverick.sharpstore.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/registration")
    private String registration(){
        return "registration";
    }
}
