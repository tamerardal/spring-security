package com.example.springsecurity.user.data.service.impl;

import com.example.springsecurity.user.data.entity.UserEntity;
import com.example.springsecurity.user.data.repository.UserRepository;
import com.example.springsecurity.user.data.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {
    private final UserRepository repository;

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void save(UserEntity user) {
        repository.save(user);
    }
}
