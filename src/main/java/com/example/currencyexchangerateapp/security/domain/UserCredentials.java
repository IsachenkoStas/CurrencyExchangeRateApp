package com.example.currencyexchangerateapp.security.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class UserCredentials {

    @Id
    private Long id;

    private String username;

    private String password;

    @Column(value = "user_role")
    private Role role;

}
