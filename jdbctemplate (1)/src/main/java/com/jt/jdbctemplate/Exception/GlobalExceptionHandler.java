package com.jt.jdbctemplate.Exception;


import com.jt.jdbctemplate.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ApiResponse handleRecordNotFoundException (RecordNotFoundException recordNotFountException){
        log.debug("<<<<<<<<< handleRecordNotFoundException()");
        List<String> finalErrors = new ArrayList();
        finalErrors.add(recordNotFountException.getMessage());
        log.info("handleRecordNotFoundException() >>>>>>>");
        ApiResponse.ApiResponseBuilder<List<String>> builder = ApiResponse.builder();
        return builder.errors(finalErrors).statusCode(HttpStatus.NOT_FOUND.value()).build();
    }
    
    @ExceptionHandler(CustomException.class)
    public ApiResponse<List<String>> handleCustomException(CustomException customException){
        log.debug("<<<<<<<<< handleCustomException()");
        String message = customException.getMessage();
        log.info("handleCustomException() >>>>>>>");
        ApiResponse.ApiResponseBuilder<List<String>> builder = ApiResponse.builder();
        return builder.errors(Arrays.asList(message)).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        log.info("<<<<<<<<< handleMethodArgumentNotValidException()");
        List<ObjectError> allErrors = methodArgumentNotValidException.getAllErrors();
        List<String> finalErrors = new ArrayList();
        for (ObjectError error : allErrors) {
            finalErrors.add(error.getDefaultMessage());
        }
        log.info("handleMethodArgumentNotValidException() >>>>>>>");
        return ApiResponse.builder().errors(finalErrors).statusCode(HttpStatus.BAD_REQUEST.value()).build();

    }

    @ExceptionHandler(value= ConstraintViolationException.class)
    public ApiResponse<Object> handleConstraintViolationException(ConstraintViolationException ex){
        log.info("<<<<<<<<< handleConstraintViolationException()");
        String message = ex.getMessage();
        log.info("handleConstraintViolationException() >>>>>>>");
        return ApiResponse.builder().errors(Arrays.asList(message)).statusCode(HttpStatus.BAD_REQUEST.value()).build();
    }

}
