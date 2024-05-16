package com.example.currencyexchangerateapp.controller;


import com.example.currencyexchangerateapp.domain.dto.RateDto;
import com.example.currencyexchangerateapp.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency-rates")
public class ExchangeRateController {

    private final ExchangeRateService rateService;
    private final ModelMapper modelMapper;

    @PostMapping("/add-rate")
    public ResponseEntity<Void> addNewRate(@RequestBody RateDto rateDto) {
        rateService.addNewRate(rateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RateDto>> getAllRates() {
        return new ResponseEntity<>(rateService.getAllRates().stream()
                .map(rate -> modelMapper.map(rate, RateDto.class)).toList(), HttpStatus.OK);
    }
}
