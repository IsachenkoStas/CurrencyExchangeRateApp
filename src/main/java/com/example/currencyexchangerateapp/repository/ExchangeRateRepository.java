package com.example.currencyexchangerateapp.repository;

import com.example.currencyexchangerateapp.domain.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

    List<ExchangeRate> findAll();
}
