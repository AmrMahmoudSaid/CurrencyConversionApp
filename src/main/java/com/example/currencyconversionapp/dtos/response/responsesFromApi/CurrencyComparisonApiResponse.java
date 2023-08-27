package com.example.currencyconversionapp.dtos.response.responsesFromApi;

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
    private Map<String,Double> conversion_rates;
    private Date time_last_update_utc;
}
