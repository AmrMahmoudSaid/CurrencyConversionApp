package com.example.currencyconversionapp.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyComparisonRequest {
    double amount;
    String from;
    List<String> currencies;
}
