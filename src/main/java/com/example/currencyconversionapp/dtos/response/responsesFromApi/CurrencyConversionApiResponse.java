package com.example.currencyconversionapp.dtos.response.responsesFromApi;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "currency convert last update should not be empty")
    private Date time_last_update_utc;
    @NotEmpty(message = "currency convert rate should not be empty")
    private double conversion_rate;
    @NotEmpty(message = "currency convert result should not be empty")
    private double conversion_result;

}
