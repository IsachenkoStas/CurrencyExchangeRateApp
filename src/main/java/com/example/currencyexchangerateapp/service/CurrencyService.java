package com.example.currencyexchangerateapp.service;

import com.example.currencyexchangerateapp.domain.Currency;
import com.example.currencyexchangerateapp.domain.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {

    void addNewCurrency(CurrencyDto currencyDto);

    List<Currency> getAllCurrencies();
}
