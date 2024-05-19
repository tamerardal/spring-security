package com.example.springsecurity.user.service.impl;

import com.example.springsecurity.user.service.UserService;
import com.example.springsecurity.config.JwtService;
import com.example.springsecurity.dto.enums.Role;
import com.example.springsecurity.dto.request.LoginRequestDto;
import com.example.springsecurity.dto.request.UserCreateDto;
import com.example.springsecurity.dto.response.AuthenticationResponseDto;
import com.example.springsecurity.user.data.entity.UserEntity;
import com.example.springsecurity.user.data.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserDataService userDataService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDto authenticate(LoginRequestDto dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        UserEntity entity = userDataService.findByUsername(dto.getUsername()).orElseThrow(() -> new UsernameNotFoundException(dto.getUsername()));

        return AuthenticationResponseDto.builder().token(jwtService.generateToken(entity)).build();
    }

    @Override
    public void register(UserCreateDto dto) {
        UserEntity entity = UserEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .password(passwordEncoder.encode(dto.getPassword()))
                .username(dto.getUsername())
                .role(Role.USER)
                .build();

        userDataService.save(entity);
    }
}
