package com.soft1851.music.admin.validator;

import com.soft1851.music.admin.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String>{
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pat = compile("^1(3|4|5|7|8)\\d{9}$");
        Matcher matcher = pat.matcher(s);
        return  matcher.find();
    }
}
