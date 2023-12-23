package com.example.user.api.dataContracts;

import com.example.user.common.api.validators.ValidateValueObject;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.FirstName;
import com.example.user.domain.valueObjects.LastName;
import com.example.user.domain.valueObjects.Password;

public class SignUpRequest {
    @ValidateValueObject(clazz = Email.class)
    public String email;
    @ValidateValueObject(clazz = FirstName.class)
    public String firstName;
    @ValidateValueObject(clazz = LastName.class)
    public String lastName;
    @ValidateValueObject(clazz = Password.class)
    public String password;
}
