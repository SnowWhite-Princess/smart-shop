package com.smart.personal.service;

import com.smart.personal.common.RespEntity;
import com.smart.personal.domain.entity.Member;

public interface MemberService {
    RespEntity<Member> findAll();
    int updateMember();
}
