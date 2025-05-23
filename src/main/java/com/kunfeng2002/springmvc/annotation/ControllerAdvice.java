package com.kunfeng2002.springmvc.annotation;

import com.kunfeng2002.springmvc.validator.Validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;

@Documented
@Constraint(validatedBy = Validator.class)
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = {TYPE_USE, METHOD, FIELD, PARAMETER,})
public @interface ControllerAdvice {
    String message() default "Not valid";
    String regexp() default"[A-Za-z0-9]";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
