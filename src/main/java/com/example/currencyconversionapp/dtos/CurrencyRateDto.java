package com.example.currencyconversionapp.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateDto {
    @NotBlank(message = "Currency code should not be empty")
    String currencyCode;
    @NotNull(message = "currency rate should not be empty")
    @Min(value = 0 , message = "currency rate should not be negative value")
    double rate;
    @NotNull(message = "currency amount should not be empty")
    @Min(value = 0 , message = "currency amount should not be negative value")
    double amount;
}
