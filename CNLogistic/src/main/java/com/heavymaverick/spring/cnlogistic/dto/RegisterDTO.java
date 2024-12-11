package com.heavymaverick.spring.cnlogistic.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table
public class RegisterDTO {

    @Column(nullable = false)
    @NotEmpty
    private String username;

    @Column
    @Email
    private String email;

    @Size(min = 3, message = "Минимальное кол-во знаков 3")
    private String password;

    private String confirmPassword;



}
