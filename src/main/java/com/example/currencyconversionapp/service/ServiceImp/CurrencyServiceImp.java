package com.example.currencyconversionapp.service.ServiceImp;

import com.example.currencyconversionapp.dtos.CurrencyRateDto;
import com.example.currencyconversionapp.dtos.request.CurrencyComparisonRequest;
import com.example.currencyconversionapp.dtos.request.CurrencyConversionRequest;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.enums.Currency;
import com.example.currencyconversionapp.exception.ResourceNotFoundException;
import com.example.currencyconversionapp.service.CurrencyService;
import com.example.currencyconversionapp.utility.FeignClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImp implements CurrencyService {
    private final FeignClientService feignClientService;

    public CurrencyServiceImp(FeignClientService feignClientService) {
        this.feignClientService = feignClientService;
    }

    private void checkIfCurrencyExist(String currencyCode){
        try {
            Currency.valueOf(currencyCode);
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("currency" , "currencyCode" ,currencyCode);
        }
    }
    private void checkIfCurrenciesExist(List<String> currencyCode){
        int index = 0;
        try {
            for (int i=0 ; i< currencyCode.size() ; i ++){
                Currency.valueOf(currencyCode.get(i));
                index++;
            }

        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("currency" , "currencyCode" ,currencyCode.get(index));
        }
    }
    @Override
    public CurrencyConversionResponse getConvertAmount(CurrencyConversionRequest currencyConversionRequest) {
        checkIfCurrencyExist(currencyConversionRequest.getFrom());
        checkIfCurrencyExist(currencyConversionRequest.getTo());
        CurrencyConversionApiResponse currencyConversionApiResponse =feignClientService.getConvertAmount(
                currencyConversionRequest.getFrom(),
                currencyConversionRequest.getTo(),
                currencyConversionRequest.getAmount());
        return createCurrencyConvetResponse(currencyConversionApiResponse);
    }
    private CurrencyConversionResponse createCurrencyConvetResponse(CurrencyConversionApiResponse convetApiResponse){
        CurrencyConversionResponse currencyResponse = new CurrencyConversionResponse();
        currencyResponse.setResult(convetApiResponse.getConversion_result());
        currencyResponse.setTime_last_update_utc(convetApiResponse.getTime_last_update_utc());
        return currencyResponse;
    }
    @Override
    public CurrencyComparisonResponse getCurrenciesRate(CurrencyComparisonRequest currencyComparisonRequest) {
        checkIfCurrenciesExist(currencyComparisonRequest.getCurrencies());
        CurrencyComparisonApiResponse comparisonApiResponse = feignClientService.getCurrenciesRates(currencyComparisonRequest.getFrom());

        return createCurrencyComparisonResponse(
                comparisonApiResponse,
                currencyComparisonRequest.getCurrencies()
        );
    }

    private CurrencyComparisonResponse createCurrencyComparisonResponse(
            CurrencyComparisonApiResponse comparisonApiResponse ,
            List<String> currencies){
        CurrencyComparisonResponse currencyComparisonResponse = new CurrencyComparisonResponse();
        currencyComparisonResponse.setConversion_rates(new ArrayList<>());
        for (String currency : currencies) {
            CurrencyRateDto currencyDto = new CurrencyRateDto();
            currencyDto.setCurrencyCode(currency);
            currencyDto.setRate(comparisonApiResponse.getConversion_rates().get(currency));
            currencyComparisonResponse.getConversion_rates().add(currencyDto);
        }
        currencyComparisonResponse.setTime_last_update_utc(comparisonApiResponse.getTime_last_update_utc());
        return currencyComparisonResponse;
    }

}
