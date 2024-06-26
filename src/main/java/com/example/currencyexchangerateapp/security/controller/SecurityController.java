package com.example.currencyexchangerateapp.security.controller;


import com.example.currencyexchangerateapp.security.domain.dto.RegistrationDTO;
import com.example.currencyexchangerateapp.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
@RequiredArgsConstructor
public class SecurityController {

    private final SecurityService securityService;

    @PostMapping("/user-registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody RegistrationDTO registrationDTO) {
        securityService.registration(registrationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
