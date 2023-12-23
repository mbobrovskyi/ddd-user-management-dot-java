package com.example.user.repositories;

import com.example.user.common.domain.Session;
import com.example.user.domain.SessionRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SessionRepositoryImpl implements SessionRepository {
    @Override
    public Session get(String token) {
        return tokenStore.get(token);
    }

    @Override
    public void set(String token, Session session, long expTime) {
        if (get(token) != null) {
            return;
        }

        tokenStore.put(token, session);
        List<String> tokens = userTokens.get(session.getUserId());
        tokens.add(token);
        userTokens.put(session.getUserId(), tokens);
    }

    @Override
    public void delete(long userId, String token) {
        if (get(token) == null) {
            return;
        }

        tokenStore.remove(token);
        List<String> tokens = userTokens.get(userId);
        userTokens.put(userId, tokens.stream().filter(x -> !x.equals(token)).toList());

    }

    @Override
    public List<String> getTokensByUserId(long userId) {
        return userTokens.get(userId);
    }

    public static final Map<String, Session> tokenStore = new HashMap<>();
    public static final Map<Long, List<String>> userTokens = new HashMap<>();
}
