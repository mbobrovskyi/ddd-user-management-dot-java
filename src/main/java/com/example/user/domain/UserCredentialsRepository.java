package com.example.user.domain;

import com.example.user.domain.entities.User;
import com.example.user.domain.entities.UserCredentials;
import com.example.user.domain.valueObjects.Email;

public interface UserCredentialsRepository {
    UserCredentials getByEmail(Email email);
    UserCredentials save(UserCredentials userCredentials);
}