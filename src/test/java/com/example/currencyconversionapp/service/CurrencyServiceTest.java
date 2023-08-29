package com.example.currencyconversionapp.service;

import com.example.currencyconversionapp.config.RedisConfig;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.dtos.response.responsesfromapi.CurrencyConversionApiResponse;
import com.example.currencyconversionapp.service.ServiceImp.CurrencyServiceImp;
import com.example.currencyconversionapp.utility.FeignClientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import java.util.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@EnableCaching
@Import(RedisConfig.class)
@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTest {
    @Mock
    private FeignClientService feignClientService;
    @InjectMocks
    private CurrencyServiceImp currencyServiceImp;
    private final Date date = new Date();
    private CurrencyConversionApiResponse currencyConversionApiResponse ;
    private CurrencyComparisonApiResponse comparisonApiResponse;

    private String from;
    private String to;
    private double amount;
    private List<String> listOfCurrencies;

    @BeforeEach
    public void init(){
        from = "USD";
        to = "EGP";
        amount = 10;
        currencyConversionApiResponse =CurrencyConversionApiResponse.builder()
                .conversion_result(20.0).time_last_update_utc(date).build();
        Map<String,Double> conversion_rates = new HashMap<>();
        conversion_rates.put("EGP",1.5);
        conversion_rates.put("QAR",1.0);
        listOfCurrencies = new ArrayList<>();
        listOfCurrencies.add("EGP");
        listOfCurrencies.add("QAR");
        comparisonApiResponse = CurrencyComparisonApiResponse.builder().conversion_rates(conversion_rates).build();
    }
    @Test
    public void ConvertAmountTest_ReturnCurrencyConversionResponse() {
        when(feignClientService.getConvertAmount(from,to,amount)).thenReturn(currencyConversionApiResponse);
        CurrencyConversionResponse currencyConversionResponse2 = currencyServiceImp.getConvertAmount(from,to,amount);
        Assertions.assertThat(currencyConversionResponse2.getResult()).isEqualTo(currencyConversionApiResponse.getConversion_result());
    }
    @Test
    public void getAllCurrenciesRate_RerutnCurrencyComparisonApiResponse(){
        when(feignClientService.getCurrenciesRates(from)).thenReturn(comparisonApiResponse);
        CurrencyComparisonApiResponse comparisonApiResponse1 = currencyServiceImp.getAllCurrenciesRate(from);
        Assertions.assertThat(comparisonApiResponse1.getConversion_rates().size()).isEqualTo(comparisonApiResponse.getConversion_rates().size());
    }
    @Test
    public  void getCurrenciesRate_ReturnCurrencyComparisonResponse(){
        CurrencyComparisonResponse currencyConversionResponse = currencyServiceImp.getCurrenciesRate(
                from,amount,listOfCurrencies,comparisonApiResponse);
        Assertions.assertThat(currencyConversionResponse.getConversion_rates().size()).isEqualTo(comparisonApiResponse.getConversion_rates().size());
    }
    @Test
    public void testGetCurrenciesRatedWithCache() {
        when(feignClientService.getCurrenciesRates(from)).thenReturn(comparisonApiResponse);

        // Act
        CurrencyComparisonApiResponse result1 = currencyServiceImp.getAllCurrenciesRate(from);
        CurrencyComparisonApiResponse result2 = currencyServiceImp.getAllCurrenciesRate(from);

        // Assert
        assertEquals(" ",comparisonApiResponse.getConversion_rates().get("EGP"), result1.getConversion_rates().get("EGP"));
        assertEquals(" ",comparisonApiResponse.getConversion_rates().get("EGP"), result2.getConversion_rates().get("EGP"));
        Mockito.verify(feignClientService,times(2)).getCurrenciesRates(from);
    }
}