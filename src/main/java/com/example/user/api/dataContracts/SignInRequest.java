package com.example.user.api.dataContracts;

import com.example.user.common.api.validators.ValidateValueObject;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.Password;

public class SignInRequest {
    @ValidateValueObject(clazz = Email.class)
    public String email;
    @ValidateValueObject(clazz = Password.class)
    public String password;
}
