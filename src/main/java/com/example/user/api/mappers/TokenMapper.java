package com.example.user.api.mappers;

import com.example.user.api.dataContracts.TokenResponse;
import com.example.user.api.dataContracts.UserResponse;
import com.example.user.domain.entities.User;
import com.example.user.domain.valueObjects.Token;

public class TokenMapper {
    public static TokenResponse tokenToResponse(Token token) {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.token = token.getToken();
        tokenResponse.expiresIn = token.getExpiresIn();
        tokenResponse.expiresAt = token.getExpiresAt();
        return tokenResponse;
    }
}
