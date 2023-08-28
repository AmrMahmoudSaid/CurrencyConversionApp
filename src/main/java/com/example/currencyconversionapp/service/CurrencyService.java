package com.example.currencyconversionapp.service;

import com.example.currencyconversionapp.dtos.response.CurrenciesResponse;
import com.example.currencyconversionapp.dtos.response.responsesFromApi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import java.util.List;

public interface CurrencyService {
    CurrencyConversionResponse getConvertAmount(String from , String to , double amount);
    CurrencyComparisonResponse getCurrenciesRate(String base , double amount , List<String> listofCodes ,CurrencyComparisonApiResponse comparisonApiResponse);
    CurrencyComparisonApiResponse getAllCurrenciesRate(String base);
    CurrenciesResponse getAllCurrencies();
    void removeRedisData();
}
