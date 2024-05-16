package com.example.currencyexchangerateapp.repository;

import com.example.currencyexchangerateapp.domain.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    List<Currency> findAll();

}
