package com.kb1.containerMarket.service;

import com.kb1.containerMarket.domain.User;
import com.kb1.containerMarket.dto.JoinReqDto;
import com.kb1.containerMarket.exception.CustomInternalServerErrorException;
import com.kb1.containerMarket.exception.CustomValidationException;
import com.kb1.containerMarket.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public User getUser(String username) throws Exception {
        User user = accountRepository.findUserByID(username);

        if(user != null){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public void duplicateUser(String username) throws Exception {
        User user = accountRepository.findUserByID(username);

        if (user != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put(user.getUsername(), "이미 사용중인 아이디입니다.");
            throw new CustomValidationException("duplicated username", errorMap);
        }
    }

    @Override
    public void register(JoinReqDto joinReqDto) throws Exception {
        User user = joinReqDto.toEntity();
        int result = accountRepository.saveUser(user);
        if (result == 0) {
            throw new CustomInternalServerErrorException("회원가입 중 문제가 발생하였습니다.");
        }
    }

    @Override
    public void updateUser(JoinReqDto joinReqDto) throws Exception {
        int result = accountRepository.updateUser(joinReqDto.toEntity());
        if (result == 0){
            throw new CustomInternalServerErrorException("회원수정 중 문제가 발생하였습니다.");
        }
    }
}
