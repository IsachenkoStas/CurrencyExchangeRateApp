package com.example.currencyexchangerateapp.service.impl;


import com.example.currencyexchangerateapp.domain.ExchangeRate;
import com.example.currencyexchangerateapp.domain.dto.RateDto;
import com.example.currencyexchangerateapp.repository.ExchangeRateRepository;
import com.example.currencyexchangerateapp.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ModelMapper modelMapper;
    private final ExchangeRateRepository exchangeRateRepository;


    @Override
    public void addNewRate(RateDto rateDto) {
        ExchangeRate exchangeRate = new ExchangeRate();
        modelMapper.map(rateDto, exchangeRate);
        exchangeRate.setLastUpdated(LocalDateTime.now());
        exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public List<ExchangeRate> getAllRates() {
        return exchangeRateRepository.findAll();
    }


}
