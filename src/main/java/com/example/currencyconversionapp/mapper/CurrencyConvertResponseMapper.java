package com.example.currencyconversionapp.mapper;

import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyConversionApiResponse;

public class CurrencyConvertResponseMapper {
    public CurrencyConversionResponse createCurrencyConvertResponse(CurrencyConversionApiResponse convetApiResponse){
        CurrencyConversionResponse currencyResponse = new CurrencyConversionResponse();
        currencyResponse.setResult(convetApiResponse.getConversion_result());
        currencyResponse.setTime_last_update_utc(convetApiResponse.getTime_last_update_utc());
        return currencyResponse;
    }
}
