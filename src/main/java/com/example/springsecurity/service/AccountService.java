package com.example.springsecurity.service;

import com.example.springsecurity.dto.AccountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    Page<AccountDto> getAccounts(Pageable pageable);
}
