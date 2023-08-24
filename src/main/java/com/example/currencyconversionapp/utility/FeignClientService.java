package com.example.currencyconversionapp.utility;

import com.example.currencyconversionapp.dtos.response.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "PayMob" ,url = "https://v6.exchangerate-api.com/v6/ecf10bab01b34bf0de9636e1")

public interface FeignClientService {
    String convertUrl= "null";
    @GetMapping("/pair/{base_code}/{target_code}/{amount}")
    CurrencyConversionApiResponse getConvertAmount(
            @PathVariable(name = "base_code") String baseCode ,
            @PathVariable(name = "target_code") String targetCode ,
            @PathVariable(name = "amount") double amount);

    @GetMapping("/latest/{base_code}")
    CurrencyComparisonApiResponse getCurrenciesRates(@PathVariable("base_code") String baseCode);


}
