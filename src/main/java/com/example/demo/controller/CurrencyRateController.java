package com.example.demo.controller;

import com.example.demo.entity.CurrencyRate;
import com.example.demo.service.CurrencyRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;

@RestController
@RequestMapping("/api/currency")
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    public CurrencyRateController(CurrencyRateService currencyRateService) {
        this.currencyRateService = currencyRateService;
    }

    @PostMapping
    public ResponseEntity<CurrencyRate> addOrUpdateCurrencyRate(
            @RequestParam String currencyPair,
            @RequestParam BigDecimal rate) {
        CurrencyRate currencyRate = currencyRateService.addOrUpdateCurrencyRate(currencyPair, rate);
        return new ResponseEntity<>(currencyRate, HttpStatus.CREATED);
    }

    @GetMapping("/{currencyPair}")
    public ResponseEntity<BigDecimal> getRate(@PathVariable String currencyPair) {
        BigDecimal rate = currencyRateService.getLatestRate(currencyPair);
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }
}