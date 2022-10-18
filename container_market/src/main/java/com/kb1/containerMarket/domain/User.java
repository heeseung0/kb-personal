package com.kb1.containerMarket.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
}