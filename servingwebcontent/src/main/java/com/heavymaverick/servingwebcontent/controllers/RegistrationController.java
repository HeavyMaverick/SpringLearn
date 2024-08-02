package com.heavymaverick.servingwebcontent.controllers;

import com.heavymaverick.servingwebcontent.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(String email, String username, String password) {
        User user = new User();
        user.set
    }
}
