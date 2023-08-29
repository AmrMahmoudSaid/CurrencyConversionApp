package com.example.currencyconversionapp.dtos.response.responsesfromapi;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConversionApiResponse {
    @NotEmpty(message = "currency convert result should not be empty")
    private String result;
    @NotNull(message = "currency convert last update should not be empty")
    private Date time_last_update_utc;
    @NotNull(message = "currency convert rate should not be empty")
    @Min(value = 0 , message = "conversion_rate should not be negative value")
    private double conversion_rate;
    @NotNull(message = "currency convert result should not be empty")
    @Min(value = 0 , message = "conversion_result should not be negative value")
    private double conversion_result;

}
