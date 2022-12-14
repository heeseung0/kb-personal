package com.kb1.containerMarket.service;

import com.kb1.containerMarket.domain.User;
import com.kb1.containerMarket.dto.JoinReqDto;

public interface AccountService {
    public void duplicateUser(String username) throws Exception;
    public void register(JoinReqDto joinReq) throws Exception;
    public User getUser(String username) throws Exception;
    public void updateUser(JoinReqDto joinReqDto) throws Exception;
}
