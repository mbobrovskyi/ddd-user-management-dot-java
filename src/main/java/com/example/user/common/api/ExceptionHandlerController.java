package com.example.user.common.api;

import com.example.user.common.errors.BaseError;
import com.example.user.common.errors.UndefinedError;
import com.example.user.common.errors.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {
    static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @Autowired
    private Environment environment;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception exception) {
        BaseError error;

        if (exception instanceof BaseError) {
            error = (BaseError) exception;
        } else if (exception instanceof MethodArgumentNotValidException) {
            Map<String, Object> errors = new HashMap<>();
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) exception;
            methodArgumentNotValidException.getFieldErrors().stream().forEach(e -> {
                errors.put(e.getField(), Arrays.asList(e.getDefaultMessage()));
            });
            error = new ValidationError().withMetadata("errors", errors);
        } else {
            error = new UndefinedError(exception);
        }

        if (error.getHttpStatusCode().value() >= HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            String stacktrace = String.join("\n", Arrays.stream(exception.getStackTrace()).map(el -> el.toString()).toList());

            if (environment.matchesProfiles("dev")) {
                error.withMetadata("stacktrace", stacktrace);
            }

            logger.error(exception.getMessage());
            logger.error(stacktrace);
        }

        ErrorResponse errorResponse = new ErrorResponse(error.getTimestamp(), error.getCode(), error.getMessage(), error.getMetadata());
        return ResponseEntity.status(error.getHttpStatusCode()).body(errorResponse);
    }
}
