package com.example.demo.service;

import com.example.demo.entity.CurrencyRate;
import com.example.demo.repository.CurrencyRateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyRateService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }
    public CurrencyRate addOrUpdateCurrencyRate(String currencyPair, BigDecimal rate) {
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setCurrencyPair(currencyPair);
        currencyRate.setRate(rate);
        currencyRate.setDate(LocalDate.now());
        return currencyRateRepository.save(currencyRate);
    }

    public BigDecimal getLatestRate(String currencyPair) {
        return currencyRateRepository.findTopByCurrencyPairOrderByDateDesc(currencyPair)
                .map(CurrencyRate::getRate)
                .orElse(BigDecimal.ZERO);
    }
}