package com.example.currencyexchangerateapp.security.service;


import com.example.currencyexchangerateapp.security.domain.Role;
import com.example.currencyexchangerateapp.security.domain.UserCredentials;
import com.example.currencyexchangerateapp.security.domain.dto.RegistrationDTO;
import com.example.currencyexchangerateapp.security.repository.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SecurityService {

    private final UserCredentialsRepository userCredentialsRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registration(RegistrationDTO registrationDTO) {
        Optional<UserCredentials> result = userCredentialsRepository.findByUsername(registrationDTO.getUsername());
        if (result.isPresent()) {
            throw new UsernameNotFoundException("User with this login already exists");
        }

        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(registrationDTO.getUsername());
        userCredentials.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        userCredentials.setRole(Role.USER);
        userCredentialsRepository.save(userCredentials);
    }
}
