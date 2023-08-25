package com.example.currencyconversionapp.service.ServiceImp;

import com.example.currencyconversionapp.dtos.CurrencyRateDto;
import com.example.currencyconversionapp.dtos.request.CurrencyComparisonRequest;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.enums.Currency;
import com.example.currencyconversionapp.exception.ResourceNotFoundException;
import com.example.currencyconversionapp.service.CurrencyService_V2;
import com.example.currencyconversionapp.utility.FeignClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImp_V2 implements CurrencyService_V2 {
    private final FeignClientService feignClientService;

    public CurrencyServiceImp_V2(FeignClientService feignClientService) {
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
    public CurrencyConversionResponse getConvertAmount(String from, String to, double amount) {
        checkIfCurrencyExist(from);
        checkIfCurrencyExist(to);
        CurrencyConversionApiResponse currencyConversionApiResponse =feignClientService.getConvertAmount(
                from,
                to,
                amount);
        return createCurrencyConvetResponse(currencyConversionApiResponse);
    }
    private CurrencyConversionResponse createCurrencyConvetResponse(CurrencyConversionApiResponse convetApiResponse){
        CurrencyConversionResponse currencyResponse = new CurrencyConversionResponse();
        currencyResponse.setResult(convetApiResponse.getConversion_result());
        currencyResponse.setTime_last_update_utc(convetApiResponse.getTime_last_update_utc());
        return currencyResponse;
    }
    @Override
    public CurrencyComparisonResponse getCurrenciesRate(String base , double amount , List<String> listofCodes) {
        checkIfCurrenciesExist(listofCodes);
        CurrencyComparisonApiResponse comparisonApiResponse = feignClientService.getCurrenciesRates(base);

        return createCurrencyComparisonResponse(
                comparisonApiResponse,
                listofCodes,
                amount
        );
    }

    private CurrencyComparisonResponse createCurrencyComparisonResponse(
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
