package com.example.user.common.errors;

public class ValidationError extends BadRequestError {

    public ValidationError(String code, String message) {
        super(code, message);
    }
}
