package com.example.user.common.errors;

import org.springframework.http.HttpStatus;

public class ConflictError extends BaseError {
    public ConflictError() {
        super(HttpStatus.CONFLICT);
    }
}
