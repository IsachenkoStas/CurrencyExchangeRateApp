package com.example.currencyexchangerateapp.service.impl;

import com.example.currencyexchangerateapp.domain.Currency;
import com.example.currencyexchangerateapp.domain.dto.CurrencyDto;
import com.example.currencyexchangerateapp.repository.CurrencyRepository;
import com.example.currencyexchangerateapp.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addNewCurrency(CurrencyDto currencyDto) {
        Currency currency = new Currency();
        modelMapper.map(currencyDto, currency);
        currencyRepository.save(currency);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }
}
