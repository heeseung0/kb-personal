package com.kb1.containerMarket.dto;

import com.kb1.containerMarket.domain.User;
import com.kb1.containerMarket.dto.validation.ValidationGroups;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class JoinReqDto {
    @NotBlank(message = "아이디는 비워 둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 4, max = 16, message = "아이디 항목은 필수 입력값입니다.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "아이디는 대소문자와 숫자만 입력 가능합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String username;

    @NotBlank(message = "비밀번호는 비워 둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 10, max = 16, message = "비밀번호 항목은 필수 입력값입니다.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z0-9-~!@#$%^&*_]*$", message = "비밀번호는 특수기호, 영문, 숫자를 모두 포함해야합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    @NotBlank(message = "이름은 비워 둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 1, max = 10, message = "이름은 1~10자 까지 가능합니다.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힇]*", groups = ValidationGroups.PatternCheckGroup.class)
    private String name;

    @NotBlank(message = "전화번호는 비워 둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 10, max = 11, groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[0-9]*", groups = ValidationGroups.PatternCheckGroup.class)
    private String mobile;

    @NotBlank(message = "이메일은 비워 둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Email
    private String email;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .name(name)
                .phone(mobile)
                .email(email)
                .role_id(1)
                .build();
    }
}
