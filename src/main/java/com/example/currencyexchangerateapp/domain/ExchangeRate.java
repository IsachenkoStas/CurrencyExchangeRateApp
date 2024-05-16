package com.example.currencyexchangerateapp.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExchangeRate {

    @Id
    private Long id;

    private String baseCurrency;

    private String targetCurrency;

    private BigDecimal currencyRate;

    @Column(value = "last_updated")
    private LocalDateTime lastUpdated;
}
