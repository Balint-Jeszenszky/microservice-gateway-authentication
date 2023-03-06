package com.example.security;

import com.example.security.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class Controller {

    @GetMapping
    public String getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetailsImpl) authentication.getPrincipal()).getUsername() + ((UserDetailsImpl) authentication.getPrincipal()).getId() + ((UserDetailsImpl) authentication.getPrincipal()).getAuthorities();
    }
}
