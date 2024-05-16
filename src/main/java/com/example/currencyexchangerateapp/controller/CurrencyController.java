package com.example.currencyexchangerateapp.controller;

import com.example.currencyexchangerateapp.domain.dto.CurrencyDto;
import com.example.currencyexchangerateapp.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final ModelMapper modelMapper;

    @PostMapping("/add-currency")
    public ResponseEntity<Void> addNewCurrency(@RequestBody CurrencyDto currencyDto) {
        currencyService.addNewCurrency(currencyDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CurrencyDto>> getAllCurrencies() {
        return new ResponseEntity<>(currencyService.getAllCurrencies().stream()
                .map(currency -> modelMapper.map(currency, CurrencyDto.class)).toList(), HttpStatus.OK);
    }
}
