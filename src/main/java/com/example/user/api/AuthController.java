package com.example.user.api;

import com.example.user.api.dataContracts.SignInRequest;
import com.example.user.api.dataContracts.SignUpRequest;
import com.example.user.api.dataContracts.TokenResponse;
import com.example.user.api.mappers.TokenMapper;
import com.example.user.common.api.BaseController;
import com.example.user.common.errors.BadRequestError;
import com.example.user.common.errors.Error;
import com.example.user.common.errors.UndefinedError;
import com.example.user.common.result.Result;
import com.example.user.domain.AuthService;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.Password;
import com.example.user.domain.valueObjects.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("sign-in")
    public TokenResponse signIn(@RequestBody SignInRequest request) throws BadRequestError {
//        Result<Email, Error> email = Email.create(request.email);
//        Result<Password, Error> password = Password.create(request.password);
//
//        Result<Token, Error> result = authService.signIn(email.getValue(), password.getValue());
//
//        return TokenMapper.tokenToDto(result.getValue());

        throw new BadRequestError("Test error");
    }

    @PostMapping("sign-up")
    public TokenResponse signUp(@RequestBody SignUpRequest request) {
//        Token token = new Token();
//        return TokenMapper.tokenToDto(token);
        return null;
    }
}
