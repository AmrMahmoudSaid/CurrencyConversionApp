package com.example.currencyconversionapp.dtos.response;

import com.example.currencyconversionapp.dtos.CurrencyDto;
import com.example.currencyconversionapp.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrenciesResponse {
    List<CurrencyDto> currencies ;

}
