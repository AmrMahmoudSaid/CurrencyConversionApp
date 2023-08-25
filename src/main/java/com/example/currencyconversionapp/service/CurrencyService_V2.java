package com.example.currencyconversionapp.service;

import com.example.currencyconversionapp.dtos.request.CurrencyComparisonRequest;
import com.example.currencyconversionapp.dtos.request.CurrencyConversionRequest;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;

import java.util.List;

public interface CurrencyService_V2 {
    CurrencyConversionResponse getConvertAmount(String from , String to , double amount);
    CurrencyComparisonResponse getCurrenciesRate(String base , double amount , List<String> listofCodes);
}
