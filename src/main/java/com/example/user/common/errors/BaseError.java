package com.example.user.common.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseError extends RuntimeException {
    private LocalDateTime timestamp = LocalDateTime.now();
    protected String code;
    protected HttpStatusCode httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    protected Map<String, Object> metadata = new HashMap<>();

    public BaseError() {
        this.code = buildCode();
    }

    public BaseError(String message) {
        super(message);
        this.code = buildCode();
    }

    public BaseError(HttpStatusCode httpStatusCode) {
        this();
        this.httpStatusCode = httpStatusCode;
    }

    public BaseError(String message, HttpStatusCode httpStatusCode) {
        this(message);
        this.httpStatusCode = httpStatusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public HttpStatusCode getHttpStatusCode() {
        return httpStatusCode;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public BaseError withMetadata(String key, Object value) {
        metadata.put(key, value);
        return this;
    }

    private String buildCode() {
        return this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1);
    }
}
