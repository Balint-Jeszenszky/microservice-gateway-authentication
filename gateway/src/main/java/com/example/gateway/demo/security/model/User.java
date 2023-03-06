package com.example.gateway.demo.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class User {
    private Integer id;
    private String username;
    private List<String> roles;
}
