package com.example.currencyconversionapp.dtos.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConversionResponse  {
    @NotNull(message = "currency convert result should not be empty")
    @Min(value = 0 , message = "result should not be negative value")
    private double result;
    @NotNull(message = "Time last update should not be empty")
    private Date time_last_update_utc;

}
