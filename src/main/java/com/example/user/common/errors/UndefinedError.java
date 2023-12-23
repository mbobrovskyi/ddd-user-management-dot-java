package com.example.user.common.errors;

public class UndefinedError extends BaseError {
    public UndefinedError(Exception ex) {
        super(ex.getMessage());
    }
}
