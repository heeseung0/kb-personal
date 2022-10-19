package com.kb1.containerMarket.service;

import com.kb1.containerMarket.dto.JoinReqDto;

public interface AccountService {
    public void duplicateUser(JoinReqDto joinReq) throws Exception;
    public void register(JoinReqDto joinReq) throws Exception;

}
