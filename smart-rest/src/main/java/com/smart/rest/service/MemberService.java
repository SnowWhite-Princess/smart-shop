
package com.smart.rest.service;

import com.smart.rest.domain.dto.MemberDto;
import com.smart.rest.domain.vo.MemberVo;

public interface MemberService {
    MemberVo login(String kw, String password);
    int register(MemberDto memberDto);
}