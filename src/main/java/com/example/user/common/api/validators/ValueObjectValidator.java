package com.example.user.common.api.validators;

import com.example.user.common.domain.ValueObject;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ValueObjectValidator implements ConstraintValidator<ValidateValueObject, Object> {
    Class<? extends ValueObject> clazz;

    @Override
    public void initialize(ValidateValueObject constraintAnnotation) {
        clazz = constraintAnnotation.clazz();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Constructor<?> c = clazz.getConstructor(value.getClass());
            c.newInstance(value);
            return true;
        } catch (InvocationTargetException error) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(error.getTargetException().getMessage()).addConstraintViolation();
            return false;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
