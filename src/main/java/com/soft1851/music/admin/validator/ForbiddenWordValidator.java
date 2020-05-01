package com.soft1851.music.admin.validator;

import com.soft1851.music.admin.annotation.ForbiddenWord;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @author ycshang
 */
public class ForbiddenWordValidator implements ConstraintValidator<ForbiddenWord, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        HashSet<Object> words = new HashSet<>();
        words.add("血腥");
        words.add("暴力");
        words.add("抑郁");
        return !words.contains(s);
    }

    public static void main(String[] args) {
        String s = "血腥";
        Pattern pat = compile("血腥、暴力、抑郁");
        Matcher matcher = pat.matcher(s);
        System.out.println(matcher.find());
    }
}
