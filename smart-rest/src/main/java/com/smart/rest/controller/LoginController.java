package com.smart.rest.controller;

import com.smart.rest.common.RespEntity;
import com.smart.rest.domain.vo.MemberVo;
import com.smart.rest.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class LoginController {
    @Resource
    MemberService memberService;

    @PostMapping("/login")
    public RespEntity<MemberVo> login(@RequestParam() String username, @RequestParam() String password) {
        MemberVo memberVo = memberService.login(username, password);
        log.info("login success!");
        return RespEntity.success(memberVo);
    }


}
