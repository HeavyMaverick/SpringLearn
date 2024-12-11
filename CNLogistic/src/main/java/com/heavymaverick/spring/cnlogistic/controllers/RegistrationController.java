package com.heavymaverick.spring.cnlogistic.controllers;

import com.heavymaverick.spring.cnlogistic.models.RegisterDto;
import com.heavymaverick.spring.cnlogistic.models.UserModel;
import com.heavymaverick.spring.cnlogistic.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model,
                           @Valid @ModelAttribute
                           RegisterDto registerDto,
                           BindingResult bindingResult) {
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            bindingResult.addError(
                    new FieldError("registerDto", "confirmPassword", "Passwords do not match"));
        }
        UserModel userModel = userRepository.findByUsername(registerDto.getUsername());
        if (userModel != null) {
            bindingResult.addError(
                    new FieldError("registerDto", "username", "Username is already in use"));
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            var bCryptEncoder = new BCryptPasswordEncoder();
            UserModel newUser = new UserModel();
            newUser.setUsername(registerDto.getUsername());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));
            newUser.setRole("USER");
            newUser.setCreatedAt(new Date());
            userRepository.save(newUser);
            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);
        } catch (Exception e) {
            bindingResult.addError(new FieldError("registerDto", "username", e.getMessage()));
        }
        return "register";
    }
}
