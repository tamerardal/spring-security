package com.example.springsecurity.account.service;

import com.example.springsecurity.dto.response.AccountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    Page<AccountDto> getAccounts(Pageable pageable);
}
