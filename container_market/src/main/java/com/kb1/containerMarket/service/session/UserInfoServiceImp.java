package com.kb1.containerMarket.service.session;

import com.kb1.containerMarket.dto.session.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImp implements UserInfoService{

    @Override
    public UserResponseDto getUserInfo(Authentication authentication) throws Exception {
        UserResponseDto userInfoResponseDto = null;
        if(authentication != null) {
             userInfoResponseDto = UserResponseDto.builder()
                     .username(authentication.getName())
                     .build();
        }else{
        }

        return userInfoResponseDto;
    }
}
