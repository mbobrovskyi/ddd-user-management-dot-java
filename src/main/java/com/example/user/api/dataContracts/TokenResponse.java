package com.example.user.api.dataContracts;

import java.time.LocalDateTime;

public class TokenResponse {
    public String token;
    public long expiresIn;
    public LocalDateTime expiresAt;
}
