package com.example.currencyconversionapp.service.ServiceImp;

import com.example.currencyconversionapp.dtos.response.*;
import com.example.currencyconversionapp.dtos.response.responsesFromApi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.responsesFromApi.CurrencyConversionApiResponse;
import com.example.currencyconversionapp.enums.Currency;
import com.example.currencyconversionapp.exception.ResourceNotFoundException;
import com.example.currencyconversionapp.mapper.CurrencyComparisonResponseMapper;
import com.example.currencyconversionapp.mapper.CurrencyConvertResponseMapper;
import com.example.currencyconversionapp.service.CurrencyService;
import com.example.currencyconversionapp.repository.CurrenciesRepo;
import com.example.currencyconversionapp.utility.FeignClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class CurrencyServiceImp implements CurrencyService {
    private final FeignClientService feignClientService;
    private final CurrenciesRepo currenciesRepo ;
    private final CurrencyComparisonResponseMapper currencyComparisonResponseMapper = new CurrencyComparisonResponseMapper();
    private final CurrencyConvertResponseMapper currencyConvertResponseMapper = new CurrencyConvertResponseMapper();

    public CurrencyServiceImp(FeignClientService feignClientService, CurrenciesRepo currenciesRepo) {
        this.feignClientService = feignClientService;
        this.currenciesRepo = currenciesRepo;
    }
    @Override
    public CurrenciesResponse getAllCurrencies() {
        return new CurrenciesResponse(currenciesRepo.getAllCurrencies());
    }

    private void checkIfCurrenciesExist(List<String> currencyCode){
        int index = 0;
        try {
            for (String s : currencyCode) {
                Currency.valueOf(s);
                index++;
            }
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("currency" , "currencyCode" ,currencyCode.get(index));
        }
    }

    @Override
    public CurrencyConversionResponse getConvertAmount(String from, String to, double amount) {
        List<String> currensies= new ArrayList<>();
        currensies.add(from);
        currensies.add(to);
        checkIfCurrenciesExist(currensies);
        CurrencyConversionApiResponse currencyConversionApiResponse =feignClientService.getConvertAmount(
                from,
                to,
                amount);
        return currencyConvertResponseMapper.createCurrencyConvertResponse(currencyConversionApiResponse);
    }

    @Override
    public CurrencyComparisonResponse getCurrenciesRate(String base , double amount , List<String> listofCodes , CurrencyComparisonApiResponse comparisonApiResponse) {
        checkIfCurrenciesExist(listofCodes);
        return currencyComparisonResponseMapper.createCurrencyComparisonResponse(
                comparisonApiResponse,
                listofCodes,
                amount
        );
    }
    @Override
    @Cacheable(cacheNames = "currenciesRate" , key = "#base")
    public CurrencyComparisonApiResponse getAllCurrenciesRate(String base){
        log.info("call api to get "+base+" rate currency at "+new Date().getTime());
        return feignClientService.getCurrenciesRates(base);
    }
    @CacheEvict(cacheNames = "currenciesRate", allEntries = true)
    public void removeRedisData(){
        log.info("data removed");
    }

}
