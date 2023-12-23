package com.example.user.repositories;

import com.example.user.common.repositories.BaseRepository;
import com.example.user.domain.UserCredentialsRepository;
import com.example.user.domain.entities.User;
import com.example.user.domain.entities.UserCredentials;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.HashPassword;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserCredentialsRepositoryImpl extends BaseRepository implements UserCredentialsRepository {
    @Override
    public UserCredentials getByEmail(Email email) {
        return userCredentials.stream().filter(uc -> uc.getEmail().equals(email)).findFirst().get();
    }

    private static final UserCredentials AliceCredentials = new UserCredentials(
            1,
            Email.create("alice@gmail.com").getValue(),
            HashPassword.create("Password22@").getValue());

    private static final UserCredentials BobCredentials = new UserCredentials(
            2,
            Email.create("bob@gmail.com").getValue(),
            HashPassword.create("Password22@").getValue());

    private static final List<UserCredentials> userCredentials = Arrays.asList(AliceCredentials, BobCredentials);
}
