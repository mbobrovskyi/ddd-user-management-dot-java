package com.example.user.common.errors;

import org.springframework.http.HttpStatus;

public class NotFoundError extends BaseError {
    public NotFoundError() {
        super(HttpStatus.NOT_FOUND);
    }
}
