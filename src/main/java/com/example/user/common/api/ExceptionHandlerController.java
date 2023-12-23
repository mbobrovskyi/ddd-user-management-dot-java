package com.example.user.common.api;

import com.example.user.common.errors.Error;
import com.example.user.common.errors.UndefinedError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest req, Exception exception) {
        Error error;

        if (exception instanceof Error) {
            error = (Error) exception;
        } else {
            error = new UndefinedError(exception);
        }

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.code = error.getCode();
        errorResponse.message = error.getMessage();
        errorResponse.metadata = error.getMetadata();

        return ResponseEntity.status(error.getHttpStatusCode()).body(errorResponse);
    }
}
