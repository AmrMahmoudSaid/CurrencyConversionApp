package com.example.currencyconversionapp.dtos.response.responsesFromApi;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
