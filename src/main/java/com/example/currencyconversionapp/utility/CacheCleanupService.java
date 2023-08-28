package com.example.currencyconversionapp.utility;

import com.example.currencyconversionapp.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
@Slf4j
public class CacheCleanupService {

    private final CurrencyService currencyService;

    public CacheCleanupService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    // Runs every hour at the top of the hour
    @Scheduled(cron = "0 0 * * * *")

    public void cleanupCache() {
        currencyService.removeRedisData();
        log.info("Redis cashing deleted at " + new Date());
    }
}