package com.smart.rest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.rest.domain.dto.MemberDto;
import com.smart.rest.domain.entity.Member;
import com.smart.rest.domain.vo.MemberVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper extends BaseMapper<Member> {
    int insert(@Param("memberDto") MemberDto memberDto);
    Member selectByUsername(@Param("username") String username);
    Member selectByPhone(@Param("phone") String Phone);
    Member selectByEmail(@Param("email") String email);


}