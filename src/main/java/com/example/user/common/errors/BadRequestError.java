package com.example.user.common.errors;

import org.springframework.http.HttpStatus;

public class BadRequestError extends Error {
    public BadRequestError(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public BadRequestError(String code, String message) {
        super(code, message, HttpStatus.BAD_REQUEST);
    }
}
