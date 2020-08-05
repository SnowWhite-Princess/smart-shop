package com.smart.rest.controller;

import com.smart.rest.common.RespEntity;
import com.smart.rest.domain.dto.MemberDto;
import com.smart.rest.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class RegisterController {
    @Resource
    MemberService memberService;

    @PostMapping("/register")
    public RespEntity<MemberDto> register(@RequestBody MemberDto memberDto) {
        memberService.register(memberDto);
        log.info("register success!");
        return RespEntity.success(memberDto);
    }
}
