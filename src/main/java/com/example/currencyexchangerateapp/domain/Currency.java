package com.example.currencyexchangerateapp.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Currency {

    @Id
    private Long id;

    private String currencyCode;

}
