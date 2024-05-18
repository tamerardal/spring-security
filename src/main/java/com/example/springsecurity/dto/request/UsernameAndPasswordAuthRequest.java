package com.example.springsecurity.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsernameAndPasswordAuthRequest {
    private String username;
    private String password;
}
