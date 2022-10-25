package com.kb1.containerMarket.service.session;

import com.kb1.containerMarket.domain.User;
import com.kb1.containerMarket.dto.session.UserResponseDto;
import com.kb1.containerMarket.repository.AccountRepository;
import com.kb1.containerMarket.security.PrincipalDetails;
import com.kb1.containerMarket.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImp implements UserInfoService{

    private final AccountService accountService;

    @Override
    public UserResponseDto getUserInfo(Authentication authentication) throws Exception {
        UserResponseDto userInfoResponseDto = null;
        User user = null;
        if(authentication != null) {
            user = accountService.getUser(authentication.getName());
             userInfoResponseDto = UserResponseDto.builder()
                     .username(authentication.getName())
                     .name(user.getName())
                     .email(user.getEmail())
                     .phone(user.getPhone())
                     .role_id(user.getRole_id())
                     .build();
        }else{
        }

        return userInfoResponseDto;
    }
}
