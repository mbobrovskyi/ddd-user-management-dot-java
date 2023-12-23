package com.example.user.common.errors;

import org.springframework.http.HttpStatus;

public class UnauthorizedError extends Error {
    public UnauthorizedError() {
        super("Unauthorized", HttpStatus.UNAUTHORIZED);
    }
}
