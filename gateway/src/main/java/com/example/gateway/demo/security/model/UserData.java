package com.example.gateway.demo.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserData {
    private User user;
    private String accessToken;
    private String refreshToken;
}