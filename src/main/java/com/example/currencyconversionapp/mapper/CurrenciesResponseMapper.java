package com.example.currencyconversionapp.mapper;

import com.example.currencyconversionapp.dtos.CurrencyRateDto;
import com.example.currencyconversionapp.dtos.response.responsesFromApi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.responsesFromApi.CurrencyConversionApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;

import java.util.ArrayList;
import java.util.List;
public class CurrenciesResponseMapper {
    public CurrencyConversionResponse createCurrencyConvetResponse(CurrencyConversionApiResponse convetApiResponse){
        CurrencyConversionResponse currencyResponse = new CurrencyConversionResponse();
        currencyResponse.setResult(convetApiResponse.getConversion_result());
        currencyResponse.setTime_last_update_utc(convetApiResponse.getTime_last_update_utc());
        return currencyResponse;
    }
    public CurrencyComparisonResponse createCurrencyComparisonResponse(
            CurrencyComparisonApiResponse comparisonApiResponse ,
            List<String> currencies,
            double amount){
        CurrencyComparisonResponse currencyComparisonResponse = new CurrencyComparisonResponse();
        currencyComparisonResponse.setConversion_rates(new ArrayList<>());
        for (String currency : currencies) {
            CurrencyRateDto currencyDto = new CurrencyRateDto();
            currencyDto.setCurrencyCode(currency);
            currencyDto.setRate(comparisonApiResponse.getConversion_rates().get(currency));
            currencyDto.setAmount(comparisonApiResponse.getConversion_rates().get(currency) * amount);
            currencyComparisonResponse.getConversion_rates().add(currencyDto);
        }
        currencyComparisonResponse.setTime_last_update_utc(comparisonApiResponse.getTime_last_update_utc());
        return currencyComparisonResponse;
    }
}
