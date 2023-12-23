package com.example.user.repositories;

import com.example.user.common.repositories.BaseRepository;
import com.example.user.domain.UserCredentialsRepository;
import com.example.user.domain.entities.UserCredentials;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.HashPassword;
import com.example.user.domain.valueObjects.Password;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserCredentialsRepositoryImpl extends BaseRepository implements UserCredentialsRepository {
    @Override
    public UserCredentials getByEmail(Email email) {
        List<UserCredentials> found = userCredentialsList.stream().filter(uc -> uc.getEmail().equals(email)).toList();
        if (found.size() == 0) {
            return null;
        }
        return found.get(0);
    }

    @Override
    public UserCredentials save(UserCredentials userCredentials) {
        userCredentialsList.add(userCredentials);
        return userCredentials;
    }

    private static UserCredentials AliceCredentials = new UserCredentials(
            1,
            new Email("alice@gmail.com"),
            new HashPassword(new Password("Password22@")));

    private static UserCredentials BobCredentials = new UserCredentials(
            2,
            new Email("bob@gmail.com"),
            new HashPassword(new Password("Password22@")));

    public static List<UserCredentials> initCredentials() {
        List<UserCredentials> credentials = new ArrayList<>();
        credentials.add(AliceCredentials);
        credentials.add(BobCredentials);
        return credentials;
    }

    private static final List<UserCredentials> userCredentialsList = initCredentials();
}
