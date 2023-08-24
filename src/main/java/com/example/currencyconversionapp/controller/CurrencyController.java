package com.example.currencyconversionapp.controller;

import com.example.currencyconversionapp.dtos.CurrenciesResponse;
import com.example.currencyconversionapp.dtos.request.CurrencyComparisonRequest;
import com.example.currencyconversionapp.dtos.request.CurrencyConversionRequest;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(
        name = "Currency REST APIs For Users"
)
public class CurrencyController {
    private final CurrencyService currencyService;

<<<<<<< HEAD

=======
>>>>>>> origin/main
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
        return ResponseEntity.ok(new CurrenciesResponse());
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
    public ResponseEntity<CurrencyConversionResponse> getConvertAmount(@RequestBody CurrencyConversionRequest currencyConversionRequest){
        return ResponseEntity.ok(currencyService.getConvertAmount(currencyConversionRequest));
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
    public ResponseEntity<CurrencyComparisonResponse> getCurrenciesRate(@RequestBody CurrencyComparisonRequest comparisonRequest){
        return ResponseEntity.ok(currencyService.getCurrenciesRate(comparisonRequest));
    }
}
