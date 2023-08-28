package com.example.currencyconversionapp.dtos.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConversionResponse  {
    @NotEmpty(message = "currency convert result should not be empty")
    private double result;
    @NotEmpty(message = "Time last update should not be empty")
    private Date time_last_update_utc;

}
