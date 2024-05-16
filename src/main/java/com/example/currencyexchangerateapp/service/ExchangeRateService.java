package com.example.currencyexchangerateapp.service;

import com.example.currencyexchangerateapp.domain.ExchangeRate;
import com.example.currencyexchangerateapp.domain.dto.RateDto;

import java.util.List;

public interface ExchangeRateService {

    void addNewRate(RateDto rateDto);

    List<ExchangeRate> getAllRates();
}
