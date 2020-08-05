package com.smart.rest.service;

import com.smart.rest.domain.dto.MemberDto;
import com.smart.rest.domain.vo.MemberVo;
import com.smart.rest.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class MemberServiceTest {

    @Resource
    MemberService memberService;

    @Test
    public void login() {
        memberService.login("admin", "admin");
    }

    @Test
    public void register() {
        MemberDto memberDto = new MemberDto();
        memberDto.setUsername("陈凯宁呀");
        memberDto.setPassword("8888");
        memberDto.setNickname("HXD");
        memberDto.setPhone("666");
        memberDto.setEmail("ckn@qq.com");
        memberDto.setIcon("xxx.png");
        memberDto.setSex("男");
        Date date = new Date();
        date.setTime(2018-03-06);
        memberDto.setBirthday(date);
        memberService.register(memberDto);
    }
}