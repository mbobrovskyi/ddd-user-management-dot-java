package com.example.user.repositories;

import com.example.user.common.domain.Session;
import com.example.user.domain.SessionRepository;
import com.example.user.domain.valueObjects.Token;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SessionRepositoryImpl implements SessionRepository {
    @Override
    public Session get(Token token) {
        return tokenStore.get(token.getToken());
    }

    @Override
    public void set(Token token, Session session) {
        if (get(token) != null) {
            return;
        }

        tokenStore.put(token.getToken(), session);
        List<String> tokens = userTokens.get(session.getUserId());
        if (tokens == null) {
            tokens = new ArrayList<>();
        }

        tokens.add(token.getToken());
        userTokens.put(session.getUserId(), tokens);
    }

    @Override
    public void delete(long userId, Token token) {
        if (get(token) == null) {
            return;
        }

        tokenStore.remove(token.getToken());
        List<String> tokens = userTokens.get(userId);
        userTokens.put(userId, tokens.stream().filter(x -> !x.equals(token.getToken())).toList());

    }

    @Override
    public List<Token> getTokensByUserId(long userId) {
        return userTokens.get(userId).stream().map(Token::new).toList();
    }

    public static final Map<String, Session> tokenStore = new HashMap<>();
    public static final Map<Long, List<String>> userTokens = new HashMap<>();
}
