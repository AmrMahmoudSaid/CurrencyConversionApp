package com.example.currencyconversionapp.controller;


import com.example.currencyconversionapp.dtos.response.CurrenciesResponse;
import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.exception.CurrencyApiException;
import com.example.currencyconversionapp.service.CurrencyService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.concurrent.ConcurrentRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1")
@Tag(
        name = "Currency REST APIs version_1 "
)
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
    @Operation(
            summary = "Get all currencies",
            description = " Get all Currencies from enum value store currency code , flag url" +
                    "and description and send it to front-end to store it "
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 OK"
    )
    @GetMapping()
    @RateLimiter(name = "limiterAPI")
    public ResponseEntity<CurrenciesResponse> getAllCurrencies(){

        return ResponseEntity.ok(currencyService.getAllCurrencies());
    }

    @Operation(
            summary = "Get amount of conversion",
            description = " Get amount of convert two currencies " +
                    "from , to  is required query param and amount not" +
                    "{ to is currency code which you would like to convert" +
                    "{from is a base currency to convert from}"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 OK"
    )
    @GetMapping("/conversion")
    @RateLimiter(name = "limiterAPI")
    public ResponseEntity<CurrencyConversionResponse> getConvertAmount(
            @RequestParam(value = "from" ) String from,
            @RequestParam(value = "to" ) String to,
            @RequestParam(value = "amount" ,required = false , defaultValue = "1") double amount
    ){
        return ResponseEntity.ok(currencyService.getConvertAmount(from,to,amount));
    }
    @Operation(
            summary = "Get rate and amount of Comparison",
            description = " Get rate and amount of compare two currencies or more" +
                    "from , list  is required query param and amount not" +
                    "required be default is 1 " +
                    "{ list is array list of Currencies codes}" +
                    "{from is a base currency to compare from}"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 OK"

    )
    @GetMapping("/comparison")
    @RateLimiter(name = "limiterAPI")
    public ResponseEntity<CurrencyComparisonResponse> getCurrenciesRate(
            @RequestParam(value = "amount" ,required = false , defaultValue = "1") double amount ,
            @RequestParam(value = "from") String from ,
            @RequestParam(value = "list")List<String> list
            ){
        CurrencyComparisonApiResponse comparisonApiResponse = currencyService.getAllCurrenciesRate(from);
        return ResponseEntity.ok(currencyService.getCurrenciesRate(from , amount,list, comparisonApiResponse));
    }
}