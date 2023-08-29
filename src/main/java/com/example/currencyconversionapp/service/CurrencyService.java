package com.example.currencyconversionapp.service;

import com.example.currencyconversionapp.dtos.response.CurrenciesResponse;
import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import java.util.List;

public interface CurrencyService {
    CurrencyConversionResponse getConvertAmount(String from , String to , double amount); //convert to currencies
    CurrencyComparisonResponse getCurrenciesRate(String base , double amount , List<String> listofCodes
            ,CurrencyComparisonApiResponse comparisonApiResponse); // compare two or more currencies
    CurrencyComparisonApiResponse getAllCurrenciesRate(String base); //get all currencies exchangerate from api call
    CurrenciesResponse getAllCurrencies(); // list all currencies which stored in currencyRepo
    void removeRedisData(); //using in cache cleanupService class [Scheduled every hour by spring boot Scheduled]
}
