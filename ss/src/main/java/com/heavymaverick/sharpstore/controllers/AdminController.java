package com.heavymaverick.sharpstore.controllers;

import com.heavymaverick.sharpstore.models.User;
import com.heavymaverick.sharpstore.models.enums.Role;
import com.heavymaverick.sharpstore.repositories.UserRepository;
import com.heavymaverick.sharpstore.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }
    @PostMapping("admin/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id){
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            if (user.isActive()){
                user.setActive(false);
                log.info("User {} has been banned", id);
            } else {
                user.setActive(true);
                log.info("Unbanned user {}", id);
            }
        }
        userService.banUser(id);
        return "redirect:/admin";
    }
    @GetMapping("/admin/user/edit/{user}")
    public String userEdit(@PathVariable("user") User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }
    @PostMapping("/admin/user/edit")
    public String userEdit(@RequestParam("userId") User user, @RequestParam Map<String, String> form){
        userService.changeUserRoles(user, form);
        return "redirect: /admin";
    }

}
