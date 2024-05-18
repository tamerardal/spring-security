package com.example.springsecurity.service.impl;

import com.example.springsecurity.client.FakeBankClient;
import com.example.springsecurity.client.dto.AccountClientDto;
import com.example.springsecurity.service.AccountService;
import com.example.springsecurity.dto.response.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final FakeBankClient client;

    @Override
    public Page<AccountDto> getAccounts(Pageable pageable) {
        List<AccountClientDto> clientDtos = client.get();
        List<AccountDto> accountDtos = new ArrayList<>();

        clientDtos.forEach(accountClientDto -> accountDtos.add(AccountDto.builder()
                .amount(accountClientDto.getDebit()).category(accountClientDto.getCategory())
                .date(accountClientDto.getTransactionDate()).id(accountClientDto.getId()).build()));

        return new PageImpl<>(accountDtos, pageable, accountDtos.size());
    }
}
