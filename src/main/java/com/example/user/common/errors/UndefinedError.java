package com.example.user.common.errors;

import org.springframework.http.HttpStatus;

public class UndefinedError extends Error {
    public UndefinedError(Exception ex) {
        super(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
