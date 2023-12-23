package com.example.user.domain;

import com.example.user.common.domain.Session;
import com.example.user.domain.valueObjects.Token;

import java.util.List;

public interface SessionRepository {
    Session get(Token token);
    void set(Token token, Session session);
    void delete(long userId, Token token);
    List<Token> getTokensByUserId(long userId);
}
