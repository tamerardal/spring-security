package com.example.springsecurity.controller;

import com.example.springsecurity.dto.AccountDto;
import com.example.springsecurity.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @GetMapping
    public Page<AccountDto> getAccounts(Pageable pageable) {
        return service.getAccounts(pageable);
    }
}
