package com.example.user.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    public LocalDateTime timestamp;
    public String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, Object> metadata;

    public ErrorResponse(LocalDateTime timestamp, String code, String message, Map<String, Object> metadata) {
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;

        if (metadata.size() > 0) {
            this.metadata = metadata;
        }
    }
}
