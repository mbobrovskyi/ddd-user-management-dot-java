package com.example.user.common.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Map;

public class Error extends Exception {
    protected String code;
    protected HttpStatusCode httpStatusCode;
    protected Map<String, Object> metadata;

    public Error(String message) {
        super(message);
        this.code = buildCode();
        this.httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public Error(String code, String message) {
        this(message);
        this.code = code;
    }

    public Error(String message, HttpStatusCode httpStatusCode) {
        this(message);
        this.httpStatusCode = httpStatusCode;
    }

    public Error(String code, String message, HttpStatusCode httpStatusCode) {
        this(code, message);
        this.httpStatusCode = httpStatusCode;
    }

    public Error(String code, String message, HttpStatusCode httpStatusCode, Map<String, Object> metadata) {
        this(code, message, httpStatusCode);
        this.metadata = metadata;
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

    public void addMetadata(String key, Object value) {
        this.metadata.put(key, value);
    }

    private String buildCode() {
        return this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1);
    }
}
