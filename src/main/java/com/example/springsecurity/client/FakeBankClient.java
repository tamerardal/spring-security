package com.example.springsecurity.client;

import com.example.springsecurity.client.dto.AccountClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "account-service", url = "https://api.sampleapis.com/fakebank")
public interface FakeBankClient {
    @GetMapping("/accounts")
    List<AccountClientDto> get();
}
