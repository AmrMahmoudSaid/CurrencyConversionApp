package com.example.currencyconversionapp.controller;


import com.example.currencyconversionapp.dtos.response.CurrenciesResponse;
import com.example.currencyconversionapp.dtos.response.responsesFromApi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1")
@Tag(
        name = "Currency REST APIs version_1 For Users"
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
    public ResponseEntity<CurrenciesResponse> getAllCurrencies(){

        return ResponseEntity.ok(currencyService.getAllCurrencies());
    }

    @Operation(
            summary = "Get all amount of conversion",
            description = " Get amount of convert two currencies"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 OK"
    )
    @GetMapping("/conversion")
    public ResponseEntity<CurrencyConversionResponse> getConvertAmount(
            @RequestParam(value = "from" ,required = true) String from,
            @RequestParam(value = "to" ,required = true) String to,
            @RequestParam(value = "amount" ,required = true) double amount
    ){
        return ResponseEntity.ok(currencyService.getConvertAmount(from,to,amount));
    }
    @Operation(
            summary = "Get all rate of Comparison",
            description = " Get rate of compare two currencies or more"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 OK"

    )
    @GetMapping("/comparison")
    public ResponseEntity<CurrencyComparisonResponse> getCurrenciesRate(
            @RequestParam(value = "amount") double amount ,
            @RequestParam(value = "from") String from ,
            @RequestParam(value = "list")List<String> list
            ){
        CurrencyComparisonApiResponse comparisonApiResponse = currencyService.getAllCurrenciesRate(from);
        return ResponseEntity.ok(currencyService.getCurrenciesRate(from , amount,list, comparisonApiResponse));
    }
}