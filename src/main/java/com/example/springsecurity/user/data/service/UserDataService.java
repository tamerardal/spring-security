package com.example.springsecurity.user.data.service;

import com.example.springsecurity.user.data.entity.UserEntity;

import java.util.Optional;

public interface UserDataService {

    Optional<UserEntity> findByUsername(String username);

    void save(UserEntity user);
}
