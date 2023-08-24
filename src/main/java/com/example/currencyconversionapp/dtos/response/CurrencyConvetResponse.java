package com.example.currencyconversionapp.dtos.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConvetResponse {
    @NotBlank
    double result;
    @NotBlank
    Date time_last_update_utc;

}
