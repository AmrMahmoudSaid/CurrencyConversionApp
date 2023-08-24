package com.example.currencyconversionapp.exception;

import com.example.currencyconversionapp.dtos.ErrorDetails;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handelResponseNotFoundException(ResourceNotFoundException exception , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date() , exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(GymAPIExeption.class)
//    public ResponseEntity<ErrorDetails> handelBlogAPIException(GymAPIExeption exception , WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(new Date() , exception.getMessage(), webRequest.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handelBlogAPIException(MethodArgumentNotValidException exception , WebRequest webRequest){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)-> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({MultipartException.class ,HttpRequestMethodNotSupportedException.class ,MethodArgumentTypeMismatchException.class })
    public ResponseEntity<ErrorDetails> handelIOMultipartExceptionnException(MultipartException exception , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date() , exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({Exception.class,IOException.class})
    public ResponseEntity<ErrorDetails> Exception(Exception exception , WebRequest webRequest){
        log.error("error happend: {}, {}", exception.getMessage() , exception.getStackTrace());
        ErrorDetails errorDetails = new ErrorDetails(new Date() , exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}