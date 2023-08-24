package com.example.currencyconversionapp.dtos.response;

import lombok.*;

import java.util.Date;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyComparisonApiResponse {
    private Map<String,Double> conversion_rates;
    private Date time_last_update_utc;
}
