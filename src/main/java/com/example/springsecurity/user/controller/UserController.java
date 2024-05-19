package com.example.springsecurity.user.controller;

import com.example.springsecurity.user.service.UserService;
import com.example.springsecurity.dto.request.LoginRequestDto;
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
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserCreateDto user) {
        service.register(user);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody LoginRequestDto user) {
        return ResponseEntity.ok(service.authenticate(user));
    }
}
