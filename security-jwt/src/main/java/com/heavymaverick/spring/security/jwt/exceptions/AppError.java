package com.heavymaverick.spring.security.jwt.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class AppError {
    private String message;
    private int status;
    private Date timestamp;

    public AppError(int status, String message) {
        this.message = message;
        this.status = status;
        this.timestamp = new Date();
    }

}
