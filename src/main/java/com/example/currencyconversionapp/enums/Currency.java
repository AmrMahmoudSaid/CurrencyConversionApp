package com.example.currencyconversionapp.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currency {
    USD("USD","https://api.exchangerate-api.com/flag-images/US.gif","United States Dollar"),
    EUR("EUR","https://api.exchangerate-api.com/flag-images/EU.gif","Euro"),
    GBP("GBP","https://api.exchangerate-api.com/flag-images/GB.gif","Pound sterling"),
    EGP("EGP","https://api.exchangerate-api.com/flag-images/EG.gif","Egyptian Pound"),
    AED("AED","https://api.exchangerate-api.com/flag-images/AE.gif","United Arab Emirates Dirham"),
    RSA("RSA","https://api.exchangerate-api.com/flag-images/SA.gif","Saudi Riyal"),
    KWD("KWD","https://api.exchangerate-api.com/flag-images/KW.gif","Kuwaiti Dinar"),
    CHF("CHF","https://api.exchangerate-api.com/flag-images/CH.gif","Swiss Franc"),
    CAD("CAD","https://api.exchangerate-api.com/flag-images/CA.gif","Canadian Dollar"),
    QAR("QAR","https://api.exchangerate-api.com/flag-images/QA.gif","Qatari Riyal");
    private final String code;
    private final String flagUrl;
    private final String desc;
}
