package com.example.currencyconversionapp.dtos.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConversionResponse  {
    @NotBlank
    private double result;
    @NotBlank
    private Date time_last_update_utc;

}
