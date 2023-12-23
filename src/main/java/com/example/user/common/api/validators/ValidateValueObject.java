package com.example.user.common.api.validators;

import com.example.user.common.domain.ValueObject;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValueObjectValidator.class)
@Target( {  ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateValueObject {
    String message() default "ValueObject is not valid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<? extends ValueObject> clazz();
}