package com.example.currencyconversionapp.exception;

import org.springframework.http.HttpStatus;

public class CurrencyApiException extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public CurrencyApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
