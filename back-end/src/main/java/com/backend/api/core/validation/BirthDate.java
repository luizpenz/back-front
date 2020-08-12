package com.backend.api.core.validation;

import com.backend.api.core.validation.imp.BirthDateImp;

import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = { BirthDateImp.class })
@Target({ FIELD })
@Retention(RUNTIME)
@Documented
public @interface BirthDate {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
