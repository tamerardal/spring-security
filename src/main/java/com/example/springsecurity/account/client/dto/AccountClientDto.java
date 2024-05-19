package com.example.springsecurity.account.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountClientDto {
    private Long id;
    private String transactionDate;
    private String description;
    private String category;
    private Double debit;
}
