package com.heavymaverick.sharpstore.controller;

import com.heavymaverick.sharpstore.models.User;
import com.heavymaverick.sharpstore.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)){
            model.addAttribute("error", "User could not be created");
            return "registration";
        }
        return "redirect:/login";
    }
    @GetMapping("/hello")
    public String secureUrl(){
        return "hello";
    }

}
