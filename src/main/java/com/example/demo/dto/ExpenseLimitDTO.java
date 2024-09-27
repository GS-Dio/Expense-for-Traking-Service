package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseLimitDTO {
    private Long id;
    private BigDecimal limitAmount;
    private String category;
    private LocalDate setDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getSetDate() {
        return setDate;
    }

    public void setSetDate(LocalDate setDate) {
        this.setDate = setDate;
    }
}
