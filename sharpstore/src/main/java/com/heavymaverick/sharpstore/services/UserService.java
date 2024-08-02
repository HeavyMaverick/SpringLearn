package com.heavymaverick.sharpstore.services;

import com.heavymaverick.sharpstore.models.User;
import com.heavymaverick.sharpstore.models.enums.Role;
import com.heavymaverick.sharpstore.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user) {
        log.info("Attempting to create new user");
        String email = user.getEmail();
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User, email {}", email);
        userRepository.save(user);
        return true;
    }
}
