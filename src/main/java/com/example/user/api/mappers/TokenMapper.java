package com.example.user.api.mappers;

import com.example.user.api.dataContracts.TokenResponse;
import com.example.user.domain.valueObjects.Token;

public class TokenMapper {
    public static TokenResponse tokenToDto(Token token) {
        TokenResponse dto = new TokenResponse();
        dto.token = token.getToken();
        dto.expInt = token.getExpInt();
        dto.expTime = token.getExpTime();
        return dto;
    }
}
