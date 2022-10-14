package com.kb1.containerMarket.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class JoinReqDto {

    @NotBlank(message = "아이디는 비워 둘 수 없습니다.")
    private String username;

    @NotBlank(message = "비밀번호는 비워 둘 수 없습니다.")
    private String password;

    @NotBlank(message = "이름은 비워 둘 수 없습니다.")
    private String name;

    @NotBlank(message = "전화번호는 비워 둘 수 없습니다.")
    private String mobile;

    @NotBlank(message = "이메일은 비워 둘 수 없습니다.")
    private String email;
}
