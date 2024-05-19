package com.example.springsecurity.user.service;

import com.example.springsecurity.dto.request.LoginRequestDto;
import com.example.springsecurity.dto.request.UserCreateDto;
import com.example.springsecurity.dto.response.AuthenticationResponseDto;

public interface UserService {
    AuthenticationResponseDto authenticate(LoginRequestDto dto);

    void register(UserCreateDto dto);
}
