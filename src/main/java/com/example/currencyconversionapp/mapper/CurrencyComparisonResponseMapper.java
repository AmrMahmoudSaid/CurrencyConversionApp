package com.example.currencyconversionapp.mapper;

import com.example.currencyconversionapp.dtos.CurrencyRateDto;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.responsesFromApi.CurrencyComparisonApiResponse;

import java.util.ArrayList;
import java.util.List;

public class CurrencyComparisonResponseMapper {
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
