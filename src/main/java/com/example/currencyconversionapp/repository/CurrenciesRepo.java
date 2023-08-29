package com.example.currencyconversionapp.repository;

import com.example.currencyconversionapp.dtos.CurrencyDto;
import com.example.currencyconversionapp.enums.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class CurrenciesRepo {
    private  List<CurrencyDto> currenciesList = new ArrayList<>();

    public List<CurrencyDto> getAllCurrencies(){return this.currenciesList;}
     public CurrenciesRepo(){
        currenciesList.add(new CurrencyDto(Currency.CAD.getCode(),Currency.CAD.getFlagUrl(),Currency.CAD.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.AED.getCode(),Currency.AED.getFlagUrl(),Currency.AED.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.CHF.getCode(),Currency.CHF.getFlagUrl(),Currency.CHF.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.EGP.getCode(),Currency.EGP.getFlagUrl(),Currency.EGP.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.KWD.getCode(),Currency.KWD.getFlagUrl(),Currency.KWD.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.EUR.getCode(),Currency.EUR.getFlagUrl(),Currency.EUR.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.GBP.getCode(),Currency.GBP.getFlagUrl(),Currency.GBP.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.QAR.getCode(),Currency.QAR.getFlagUrl(),Currency.QAR.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.SAR.getCode(),Currency.SAR.getFlagUrl(),Currency.SAR.getDesc()));
        currenciesList.add(new CurrencyDto(Currency.USD.getCode(),Currency.USD.getFlagUrl(),Currency.USD.getDesc()));
    }
}
