package com.example.currencyconversionapp.controller;


import com.example.currencyconversionapp.dtos.CurrenciesResponse;
import com.example.currencyconversionapp.dtos.request.CurrencyComparisonRequest;
import com.example.currencyconversionapp.dtos.request.CurrencyConversionRequest;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.service.CurrencyService;
import com.example.currencyconversionapp.service.CurrencyService_V2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@Tag(
        name = "Currency REST APIs version_2 For Users"
)
public class CurrencyController_V2 {
    private final CurrencyService_V2 currencyService;

    public CurrencyController_V2(CurrencyService_V2 currencyService) {
        this.currencyService = currencyService;
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
        return ResponseEntity.ok(currencyService.getCurrenciesRate(from , amount,list));
    }
}