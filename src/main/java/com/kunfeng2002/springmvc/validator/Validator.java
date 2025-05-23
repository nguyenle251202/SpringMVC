package com.kunfeng2002.springmvc.validator;

import com.kunfeng2002.springmvc.annotation.ControllerAdvice;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class Validator implements ConstraintValidator<ControllerAdvice, String> {

    @Override
    public void initialize(ControllerAdvice controllerAdvice) {
        ConstraintValidator.super.initialize(controllerAdvice);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        return contactField != null && contactField.matches("[0-9]+")
//                && (contactField.length() > 8) && (contactField.length() < 14);
        return s !=null && s.matches("^[a-zA-Z0-9_]+$")
                && s.length() > 0 && s.length() <= 50;
    }
}
