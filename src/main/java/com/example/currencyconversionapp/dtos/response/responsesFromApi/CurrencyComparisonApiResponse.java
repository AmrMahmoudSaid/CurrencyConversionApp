package com.example.currencyconversionapp.dtos.response.responsesFromApi;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyComparisonApiResponse implements Serializable {
    @NotEmpty(message = "currencies rate list should not be empty")
    private Map<String,Double> conversion_rates;
    @NotEmpty(message = "Time last update should not be empty")
    private Date time_last_update_utc;
}
