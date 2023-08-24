package com.example.currencyconversionapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Currency Conversion system Rest APIs",
                version = "v1.0",
                contact = @Contact(
                        name = "Amr Mahmoud",
                        email = "amrmahmoud1900@gmail.com"
                )
        )
)
public class CurrencyConversionAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionAppApplication.class, args);
    }

}
