package com.kb1.containerMarket.service.session;

import com.kb1.containerMarket.dto.session.UserResponseDto;
import org.springframework.security.core.Authentication;

public interface UserInfoService {
    public UserResponseDto getUserInfo(Authentication authentication) throws Exception;
}
