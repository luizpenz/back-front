package com.backend.api.core.validation.imp;

import com.backend.api.core.validation.BirthDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BirthDateImp implements ConstraintValidator<BirthDate, LocalDate> {

    @Override
    public void initialize(BirthDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return birthDateValidate(value);
    }

    private static boolean birthDateValidate(LocalDate value) {
        return value.compareTo(LocalDate.now()) <= 0;
    }

}
