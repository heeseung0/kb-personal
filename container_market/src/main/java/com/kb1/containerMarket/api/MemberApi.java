package com.kb1.containerMarket.api;


import com.kb1.containerMarket.dto.CMRespDto;
import com.kb1.containerMarket.dto.JoinReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class MemberApi {


    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinReqDto joinReqDto) throws Exception{
        return ResponseEntity.created(null).body(new CMRespDto<>("회원가입 성공", joinReqDto.getUsername()));
    }
}
