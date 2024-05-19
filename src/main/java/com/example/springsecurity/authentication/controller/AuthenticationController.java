package com.example.springsecurity.authentication.controller;

import com.example.springsecurity.authentication.service.AuthenticationService;
import com.example.springsecurity.dto.request.AuthenticationRequestDto;
import com.example.springsecurity.dto.request.UserCreateDto;
import com.example.springsecurity.dto.response.AuthenticationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody UserCreateDto user) {
        return ResponseEntity.ok(service.register(user));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody AuthenticationRequestDto user) {
        return ResponseEntity.ok(service.authenticate(user));
    }
}
