package com.example.currencyconversionapp.service.ServiceImp;

import com.example.currencyconversionapp.dtos.CurrencyDto;
import com.example.currencyconversionapp.dtos.response.*;
import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyConversionApiResponse;
import com.example.currencyconversionapp.enums.Currency;
import com.example.currencyconversionapp.exception.ResourceNotFoundException;
import com.example.currencyconversionapp.mapper.CurrencyComparisonResponseMapper;
import com.example.currencyconversionapp.mapper.CurrencyConvertResponseMapper;
import com.example.currencyconversionapp.service.CurrencyService;
import com.example.currencyconversionapp.utility.FeignClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CurrencyServiceImp implements CurrencyService {
    private final FeignClientService feignClientService;
    private final CurrencyComparisonResponseMapper currencyComparisonResponseMapper = new CurrencyComparisonResponseMapper();
    private final CurrencyConvertResponseMapper currencyConvertResponseMapper = new CurrencyConvertResponseMapper();

    public CurrencyServiceImp(FeignClientService feignClientService) {
        this.feignClientService = feignClientService;
    }
    @Override
    // don't need to cacheable because currencies is actually in memory
    public CurrenciesResponse getAllCurrencies() {
        CurrenciesResponse currenciesResponse=new CurrenciesResponse();
        currenciesResponse.setCurrencies(Arrays.stream(Currency.values()).map(it ->
                new CurrencyDto(it.getCode(),it.getFlagUrl(),it.getDesc())).collect(Collectors.toList()));
        return currenciesResponse;
    }
    @Override
    @Cacheable(cacheNames = "currenciesRate" , key = "#base")
    public CurrencyComparisonApiResponse getAllCurrenciesRate(String base){
        log.info("call api to get "+base+" rate currency at "+new Date().getTime());
        return feignClientService.getCurrenciesRates(base);
    }

    private void checkIfCurrenciesExist(List<String> currenciesCode){ //check currencies code which your enter if it exist in our enum value
        int index = 0;
        try {
            for (String s : currenciesCode) {
                Currency.valueOf(s);
                index++;
            }
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("currency" , "currencyCode" ,currenciesCode.get(index));
        }
    }

    @Override
    // don't need to cacheable because it is a dynamic fun
    public CurrencyConversionResponse getConvertAmount(String from, String to, double amount) {
        List<String> currensies= new ArrayList<>(); // make array of currencies to check in one function
        currensies.add(from);
        currensies.add(to);
        checkIfCurrenciesExist(currensies); // check currency exist
        CurrencyConversionApiResponse currencyConversionApiResponse =feignClientService.getConvertAmount( //call api for convert
                from,
                to,
                amount);
        return currencyConvertResponseMapper.createCurrencyConvertResponse(currencyConversionApiResponse);
    }

    @Override
    // don't need to cacheable because we actually store value from getAllCurrenciesRate fun
    public CurrencyComparisonResponse getCurrenciesRate(String base , double amount , List<String> listofCodes , CurrencyComparisonApiResponse comparisonApiResponse) {
        checkIfCurrenciesExist(listofCodes); // check currency exist
        return currencyComparisonResponseMapper.createCurrencyComparisonResponse( //map to Comparison Response and send the response
                comparisonApiResponse,
                listofCodes,
                amount
        );
    }
    //using in cache cleanupService class [Scheduled every hour]
    @CacheEvict(cacheNames = "currenciesRate", allEntries = true)
    public void removeRedisData(){
        log.info("data removed");
    }

}
