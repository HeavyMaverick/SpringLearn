package com.heavymaverick.spring.cnlogistic.models;

import jakarta.persistence.Table;
import lombok.Data;

@Table
@Data
public class RegisterDto {

    private String username;
}
