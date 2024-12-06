package com.heavymaverick.spring.cnlogistic.services;

import com.heavymaverick.spring.cnlogistic.models.UserModel;
import com.heavymaverick.spring.cnlogistic.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username);
        if (user != null) {
            return User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(String.valueOf(user.getRoles()))
                    .build();
        }
        return null;
    }
}
