package com.example.currencyexchangerateapp.security.service;

import com.example.currencyexchangerateapp.security.domain.UserCredentials;
import com.example.currencyexchangerateapp.security.repository.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> userFromDB = userCredentialsRepository.findByUsername(username);
        if (userFromDB.isEmpty()) {
            throw new UsernameNotFoundException("user with username: " + username + " not found");
        }

        UserCredentials user = userFromDB.get();
        return User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .build();
    }
}
