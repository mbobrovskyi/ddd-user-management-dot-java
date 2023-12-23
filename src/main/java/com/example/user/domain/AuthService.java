package com.example.user.domain;

import com.example.user.common.errors.BadRequestError;
import com.example.user.common.errors.Error;
import com.example.user.common.errors.NotFoundError;
import com.example.user.common.errors.UnauthorizedError;
import com.example.user.common.result.Result;
import com.example.user.domain.entities.User;
import com.example.user.domain.entities.UserCredentials;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.Password;
import com.example.user.domain.valueObjects.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    public Result<Token, Error> signIn(Email email, Password password) {
        UserCredentials userCredentials = userCredentialsRepository.getByEmail(email);
        if (userCredentials == null) {
            return Result.Error(new UnauthorizedError());
        }

        if (!userCredentials.getHashPassword().compare(password)) {
            return Result.Error(new UnauthorizedError());
        }

        User user = userRepository.getByEmail(email);
        if (user == null) {
            return Result.Error(new UnauthorizedError());
        }

        Token token = new Token(user);

        return Result.Success(token);
    }
}
