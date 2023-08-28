package com.example.currencyconversionapp.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateDto {
    @NotEmpty(message = "Currency code should not be empty")
    String currencyCode;
    @NotEmpty(message = "currency rate should not be empty")
    double rate;
    @NotEmpty(message = "currency amount should not be empty")
    double amount;
}
