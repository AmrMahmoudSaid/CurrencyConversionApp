package com.example.currencyconversionapp.controller;

import com.example.currencyconversionapp.dtos.CurrencyDto;
import com.example.currencyconversionapp.dtos.response.CurrenciesResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyComparisonResponse;
import com.example.currencyconversionapp.dtos.response.CurrencyConversionResponse;
import com.example.currencyconversionapp.dtos.response.responsesFromApi.CurrencyComparisonApiResponse;
import com.example.currencyconversionapp.enums.Currency;
import com.example.currencyconversionapp.service.ServiceImp.CurrencyServiceImp;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers =CurrencyController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CurrencyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CurrencyServiceImp currencyServiceImp;
    private CurrenciesResponse currenciesResponse;
    private String from;
    private String to;
    private double amount;
    private List<String> listOfCurrencies ;
    private CurrencyConversionResponse currencyConversionResponse;
    private CurrencyComparisonResponse currencyComparisonResponse;
    CurrencyComparisonApiResponse comparisonApiResponse;

    @BeforeEach
    public void init(){
        CurrencyDto currencyDto = new CurrencyDto(Currency.EUR.getCode(), Currency.EUR.getFlagUrl(), Currency.EUR.getDesc());
        currencyConversionResponse = new CurrencyConversionResponse();
        List<CurrencyDto> currencyDtoList= new ArrayList<>();
        currencyDtoList.add(currencyDto);
        currenciesResponse = new CurrenciesResponse();
        currenciesResponse.setCurrencies(currencyDtoList);
        from = "USD";
        to = "EGP";
        amount = 10;
        listOfCurrencies = new ArrayList<>();
        listOfCurrencies.add("EGP");
        listOfCurrencies.add("QAR");
        currencyComparisonResponse =new CurrencyComparisonResponse();
        currencyConversionResponse = new CurrencyConversionResponse();
        currencyConversionResponse.setResult(300);
    }
    @Test
    public void CurrencyController_getAllCurrencies() throws Exception{
        when(currencyServiceImp.getAllCurrencies()).thenReturn(currenciesResponse);
        ResultActions response = mockMvc.perform(get("/api/v1")
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());
    }
    @Test
    public void CurrencyController_GetConvertedAmount() throws Exception{
        when(currencyServiceImp.getConvertAmount(from,to,amount)).thenReturn(currencyConversionResponse);
        ResultActions response = mockMvc.perform(get("/api/v1/conversion")
                .param("from" ,from)
                .param("to" ,to)
                .param("amount" ,String.valueOf(amount))
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result", CoreMatchers.is(currencyConversionResponse.getResult())));
    }
    @Test
    public void CurrencyController_GetcomparisonAmount() throws Exception{
        when(currencyServiceImp.getCurrenciesRate(from,amount,listOfCurrencies,comparisonApiResponse)).thenReturn(currencyComparisonResponse);
        ResultActions response = mockMvc.perform(get("/api/v1/comparison")
                .param("from" ,from)
                .param("amount" ,String.valueOf(amount))
                .param("list" , String.valueOf(listOfCurrencies))
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());
    }

}