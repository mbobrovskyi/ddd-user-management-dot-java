package com.example.user.domain;

import com.example.user.common.domain.Session;

import java.util.List;

public interface SessionRepository {
    Session get(String token);
    void set(String token, Session session, long expTime);
    void delete(long userId, String token);
    List<String> getTokensByUserId(long userId);
}
