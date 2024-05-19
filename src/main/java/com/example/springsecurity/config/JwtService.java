package com.example.springsecurity.config;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {

    String extractUsername(String token);

    boolean validateToken(String token, UserDetails userDetails);

    String generateToken(UserDetails userDetails);

    String generateToken(Map<String, Object> claims, UserDetails userDetails);
}
