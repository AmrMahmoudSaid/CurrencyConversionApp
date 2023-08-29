package com.example.currencyconversionapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    @NotBlank(message = "code should not be empty")
    private  String code;
    @NotBlank(message = "flagUrl should not be empty")
    private  String flagUrl;
    @NotBlank(message = "description should not be empty")
    private  String desc;
}
