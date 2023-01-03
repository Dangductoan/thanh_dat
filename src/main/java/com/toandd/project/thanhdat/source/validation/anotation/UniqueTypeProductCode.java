package com.toandd.project.thanhdat.source.validation.anotation;

import com.toandd.project.thanhdat.source.validation.validator.UniqueTypeProductCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueTypeProductCodeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueTypeProductCode {
    String message() default "{type.code.existed}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
