package com.heavymaverick.servingwebcontent;

import jakarta.persistence.*;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Set<Role> roles;
}
