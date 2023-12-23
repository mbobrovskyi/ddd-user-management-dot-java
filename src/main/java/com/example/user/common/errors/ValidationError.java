package com.example.user.common.errors;

import java.util.Map;

public class ValidationError extends BadRequestError {
    public ValidationError() {
        super("One or more validation errors occured.");
    }

    public ValidationError(String message) {
        super(message);
    }
}
