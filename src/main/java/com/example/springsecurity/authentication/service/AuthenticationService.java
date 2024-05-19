package com.example.springsecurity.authentication.service;

import com.example.springsecurity.dto.request.AuthenticationRequestDto;
import com.example.springsecurity.dto.request.UserCreateDto;
import com.example.springsecurity.dto.response.AuthenticationResponseDto;

public interface AuthenticationService {
    AuthenticationResponseDto authenticate(AuthenticationRequestDto dto);

    AuthenticationResponseDto register(UserCreateDto dto);
}
