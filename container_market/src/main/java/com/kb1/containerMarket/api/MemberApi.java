package com.kb1.containerMarket.api;


import com.kb1.containerMarket.aop.annotation.LogAspect;
import com.kb1.containerMarket.aop.annotation.ValidAspect;
import com.kb1.containerMarket.dto.CMRespDto;
import com.kb1.containerMarket.dto.JoinReqDto;
import com.kb1.containerMarket.dto.validation.ValidationSequence;
import com.kb1.containerMarket.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;


@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class MemberApi {

    private final AccountService accountService;

    @LogAspect
    @ValidAspect
    @PostMapping("/join")
    public ResponseEntity<?> join(@Validated(ValidationSequence.class) @RequestBody JoinReqDto joinReqDto, BindingResult bindingResult) throws Exception{
        accountService.register(joinReqDto);
        return ResponseEntity.created(URI.create("/member/login")).body(new CMRespDto<>("회원가입 성공", joinReqDto.getUsername()));
    }

    @LogAspect
    @ValidAspect
    @PostMapping("/modify")
    public ResponseEntity<?> modify(){
        return ResponseEntity.ok().body(new CMRespDto<>("회원수정 성공", null));
    }
}
