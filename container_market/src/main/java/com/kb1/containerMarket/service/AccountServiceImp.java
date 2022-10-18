package com.kb1.containerMarket.service;

import com.kb1.containerMarket.domain.User;
import com.kb1.containerMarket.dto.JoinReqDto;
import com.kb1.containerMarket.exception.CustomInternalServerErrorException;
import com.kb1.containerMarket.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService{

    private final AccountRepository accountRepository;
//
//    @Override
//    public void duplicateUser(JoinReqDto joinReq) throws Exception {
//
//    }

    @Override
    public void register(JoinReqDto joinReqDto) throws Exception {
        User user = joinReqDto.toEntity();
        int result = accountRepository.saveUser(user);
        if(result == 0){
            throw new CustomInternalServerErrorException("회원가입 중 문제가 발생하였습니다.");
        }
    }
}
