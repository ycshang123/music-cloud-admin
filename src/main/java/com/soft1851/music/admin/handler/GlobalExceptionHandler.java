package com.soft1851.music.admin.handler;

import com.auth0.jwt.exceptions.InvalidClaimException;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.controller.SongController;
import com.soft1851.music.admin.exception.CustomException;
import com.soft1851.music.admin.exception.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 自定义异常的处理，统一在这里捕获返回JSON格式的友好提示
     *
     * @param exception
     * @return ResponseResult
     */
    @ExceptionHandler(value = {JwtException.class})
    @ResponseBody
    public ResponseResult sendError(JwtException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(exception.getResultCode());
    }

    /**
     * 自定义异常的处理，统一在这里捕获返回JSON格式的友好提示
     *
     * @param exception
     * @return ResponseResult
     */
    @ExceptionHandler(value = {CustomException.class})
    @ResponseBody
    public ResponseResult sendError(CustomException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(exception.getResultCode());
    }

    /**
     * InvalidClaimException异常的处理
     *
     * @param exception
     * @return ResponseResult
     */
    @ExceptionHandler(value = {InvalidClaimException.class})
    @ResponseBody
    public ResponseResult sendError(InvalidClaimException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.USER_TOKEN_EXPIRES);
    }


    /**
     * NPE异常的处理
     *
     * @param exception
     * @return ResponseResult
     */
    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    public ResponseResult sendError(NullPointerException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    /**
     * IO异常的处理
     *
     * @param exception
     * @return ResponseResult
     */
    @ExceptionHandler(value = {IOException.class})
    @ResponseBody
    public ResponseResult sendError(IOException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.CAPTCHA_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handlerValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

    }

    //在全局异常处理中添加对参数校验出错的400异常(BAD_REQUEST)的处理
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handlerConstraintViolationException(ConstraintViolationException e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}