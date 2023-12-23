package com.example.user.common.errors;

import org.springframework.http.HttpStatus;

public class UnauthorizedError extends BaseError {
    public UnauthorizedError() {
        super(HttpStatus.UNAUTHORIZED);
    }
}
