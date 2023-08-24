package com.example.currencyconversionapp.service;

import com.example.currencyconversionapp.dtos.request.CurrencyComparisonRequest;
import com.example.currencyconversionapp.dtos.request.CurrencyConversionRequest;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;

public interface CurrencyService {
    CurrencyConversionResponse getConvertAmount(CurrencyConversionRequest currencyConversionRequest);
    CurrencyComparisonResponse getCurrenciesRate(CurrencyComparisonRequest currencyComparisonRequest);
}
