package com.soft1851.music.admin.annotation;


import com.soft1851.music.admin.validator.ForbiddenWordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ForbiddenWordValidator.class)
@Documented
public @interface ForbiddenWord {

    String message() default "该名称含有禁词，格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
