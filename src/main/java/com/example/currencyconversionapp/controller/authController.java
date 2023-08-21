package com.example.currencyconversionapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class authController {
    @GetMapping
    public String get(){
        return "Hello world";
    }
}
