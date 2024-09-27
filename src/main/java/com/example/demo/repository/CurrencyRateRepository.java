package com.example.demo.repository;

import com.example.demo.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
    Optional<CurrencyRate> findTopByCurrencyPairOrderByDateDesc(String currencyPair);
}
