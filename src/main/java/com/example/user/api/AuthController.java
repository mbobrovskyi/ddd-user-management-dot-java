package com.example.user.api;

import com.example.user.api.dataContracts.SignInRequest;
import com.example.user.api.dataContracts.SignUpRequest;
import com.example.user.api.dataContracts.TokenResponse;
import com.example.user.api.mappers.TokenMapper;
import com.example.user.domain.AuthService;
import com.example.user.domain.valueObjects.*;
import jakarta.validation.Valid;
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
    public TokenResponse signIn(@Valid @RequestBody SignInRequest request) {
        SignIn signIn = new SignIn(new Email(request.email), new Password(request.password));
        Token token = authService.signIn(signIn);
        return TokenMapper.tokenToResponse(token);
    }

    @PostMapping("sign-up")
    public TokenResponse signUp(@RequestBody SignUpRequest request) {
        SignUp signUp = new SignUp(
                new Email(request.email),
                new FirstName(request.firstName),
                new LastName(request.lastName),
                new Password(request.password));

        Token token = authService.signUp(signUp);
        return TokenMapper.tokenToResponse(token);
    }
}
