package com.example.currencyconversionapp.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currency {
    USD("USD","https://www.xe.com/static-images/usd.static.e8b657d1161a08a32415d284a8e1dc89.svg","United States Dollar"),
    EUR("EUR","https://www.xe.com/static-images/eur.static.7c6f881c3b6506b03bcbda3644485094.svg","Euro"),
    GBP("GBP","https://www.xe.com/static-images/gbp.static.da0ca3d1b6d9e74642276a0ea3cde603.svg","Pound sterling"),
    EGP("EGP","https://www.xe.com/static-images/egp.static.df88137050e409e79db3433d9c8b1493.svg","Egyptian Pound"),
    AED("AED","https://www.xe.com/static-images/aed.static.93a2e850c3b1ada8d436ede89073d8ac.svg","United Arab Emirates Dirham"),
    RSA("SAR","https://www.xe.com/static-images/sar.static.172f85c044a4581c37da224739c18ecf.svg","Saudi Riyal"),
    KWD("KWD","https://www.xe.com/static-images/kwd.static.d6c2b5cfa6e8626418dfa204f9c3ee20.svg","Kuwaiti Dinar"),
    CHF("CHF","https://www.xe.com/static-images/chf.static.eb65ed7418d2ad8703a7c9c54467b785.svg","Swiss Franc"),
    CAD("CAD","https://www.xe.com/static-images/cad.static.0bfb6a6d0adf4f3b1c28c0c90248b18b.svg","Canadian Dollar"),
    QAR("QAR","https://www.xe.com/static-images/qar.static.c24ed06a965876b6d172ddb5262c5caa.svg","Qatari Riyal");
    private final String code;
    private final String flagUrl;
    private final String desc;
}
