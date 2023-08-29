package com.example.currencyconversionapp.utility;

import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyConversionApiResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "PayMob" ,url = "${CURRENCYCONVERSION_URL}")

public interface FeignClientService {
    @GetMapping("/pair/{base_code}/{target_code}/{amount}")
    @CircuitBreaker(name = "CircuitBreakerAPI" )
    @Retry(name = "RetryAPI" )
    CurrencyConversionApiResponse getConvertAmount(
            @PathVariable(name = "base_code") String baseCode ,
            @PathVariable(name = "target_code") String targetCode ,
            @PathVariable(name = "amount") double amount);

    @GetMapping("/latest/{base_code}")
    @CircuitBreaker(name = "CircuitBreakerAPI" )
    @Retry(name = "RetryAPI" )
    CurrencyComparisonApiResponse getCurrenciesRates(@PathVariable("base_code") String baseCode);
}
