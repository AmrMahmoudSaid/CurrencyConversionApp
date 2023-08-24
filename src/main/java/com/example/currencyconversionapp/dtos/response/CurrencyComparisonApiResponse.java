package com.example.currencyconversionapp.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyComparisonApiResponse {
    Map<String,Double> conversion_rates;
}
