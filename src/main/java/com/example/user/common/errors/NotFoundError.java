package com.example.user.common.errors;

import org.springframework.http.HttpStatus;

public class NotFoundError extends Error {
    public NotFoundError() {
        super("Not Found", HttpStatus.NOT_FOUND);
    }
}
