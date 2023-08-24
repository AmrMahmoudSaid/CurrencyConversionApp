package com.example.currencyconversionapp.dtos;

import com.example.currencyconversionapp.enums.Currency;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class CurrenciesResponse {
    List<CurrencyDto> currencies= new ArrayList<>();
    public CurrenciesResponse(){
        currencies.add(new CurrencyDto(Currency.CAD.getCode(),Currency.CAD.getFlagUrl(),Currency.CAD.getDesc()));
        currencies.add(new CurrencyDto(Currency.AED.getCode(),Currency.AED.getFlagUrl(),Currency.AED.getDesc()));
        currencies.add(new CurrencyDto(Currency.CHF.getCode(),Currency.CHF.getFlagUrl(),Currency.CHF.getDesc()));
        currencies.add(new CurrencyDto(Currency.EGP.getCode(),Currency.EGP.getFlagUrl(),Currency.EGP.getDesc()));
        currencies.add(new CurrencyDto(Currency.KWD.getCode(),Currency.KWD.getFlagUrl(),Currency.KWD.getDesc()));
        currencies.add(new CurrencyDto(Currency.EUR.getCode(),Currency.EUR.getFlagUrl(),Currency.EUR.getDesc()));
        currencies.add(new CurrencyDto(Currency.GBP.getCode(),Currency.GBP.getFlagUrl(),Currency.GBP.getDesc()));
        currencies.add(new CurrencyDto(Currency.QAR.getCode(),Currency.QAR.getFlagUrl(),Currency.QAR.getDesc()));
        currencies.add(new CurrencyDto(Currency.RSA.getCode(),Currency.RSA.getFlagUrl(),Currency.RSA.getDesc()));
        currencies.add(new CurrencyDto(Currency.USD.getCode(),Currency.USD.getFlagUrl(),Currency.USD.getDesc()));
    }
}
