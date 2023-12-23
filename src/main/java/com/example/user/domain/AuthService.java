package com.example.user.domain;

import com.example.user.common.domain.Session;
import com.example.user.common.errors.ConflictError;
import com.example.user.common.errors.UnauthorizedError;
import com.example.user.domain.entities.User;
import com.example.user.domain.entities.UserCredentials;
import com.example.user.domain.valueObjects.HashPassword;
import com.example.user.domain.valueObjects.SignIn;
import com.example.user.domain.valueObjects.SignUp;
import com.example.user.domain.valueObjects.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public Token signIn(SignIn signIn) {
        UserCredentials userCredentials = userCredentialsRepository.getByEmail(signIn.getEmail());
        if (userCredentials == null) {
            throw new UnauthorizedError();
        }

        if (!userCredentials.getHashPassword().compare(signIn.getPassword())) {
            throw new UnauthorizedError();
        }

        Token token = new Token();
        Session session = new Session(userCredentials.getId());
        sessionRepository.set(token, session);

        return token;
    }

    public Token signUp(SignUp signUp) {
        User user = userRepository.getByEmail(signUp.getEmail());
        if (user != null) {
            throw new ConflictError();
        }

        user = userRepository.save(new User(signUp.getEmail(), signUp.getFirstName(), signUp.getLastName()));
        UserCredentials userCredentials = new UserCredentials(user.getId(), user.getEmail(), new HashPassword(signUp.getPassword()));
        userCredentialsRepository.save(userCredentials);

        return signIn(new SignIn(signUp.getEmail(), signUp.getPassword()));
    }
}
