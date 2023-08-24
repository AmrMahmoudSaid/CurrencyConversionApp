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
public class CurrencyConversionApiResponse {
    @NotBlank
    private String result;
    @NotBlank
    private Date time_last_update_utc;
    @NotBlank
    private double conversion_rate;
    @NotBlank
    private double conversion_result;

}
