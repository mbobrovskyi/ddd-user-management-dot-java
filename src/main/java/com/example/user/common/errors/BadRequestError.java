package com.example.user.common.errors;

import org.springframework.http.HttpStatus;

public class BadRequestError extends BaseError {
    public BadRequestError(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
