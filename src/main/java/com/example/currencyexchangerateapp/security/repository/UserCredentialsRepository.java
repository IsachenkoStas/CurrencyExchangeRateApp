package com.example.currencyexchangerateapp.security.repository;

import com.example.currencyexchangerateapp.security.domain.UserCredentials;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCredentialsRepository extends CrudRepository<UserCredentials, Long> {

    Optional<UserCredentials> findByUsername(String username);
}
