package com.heavymaverick.spring.security.jwt.dtos;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
