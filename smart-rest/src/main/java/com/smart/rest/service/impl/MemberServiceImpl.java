package com.smart.rest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.rest.common.RespCode;
import com.smart.rest.domain.dto.MemberDto;
import com.smart.rest.domain.entity.Member;
import com.smart.rest.domain.vo.MemberVo;
import com.smart.rest.exception.ServiceException;
import com.smart.rest.mapper.MemberMapper;
import com.smart.rest.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Resource
    MemberMapper memberMapper;

    /**
     * tooken
     *
     * @param kw
     * @param password
     * @return
     */
    @Override
    public MemberVo login(String kw, String password) {
        MemberVo vo = null;
        // 通过用户名手机号邮箱
        QueryWrapper<Member> qw = new QueryWrapper<>();
        qw.eq(Member.COL_USERNAME, kw)
                .or()
                .eq(Member.COL_PHONE, kw)
                .or()
                .eq(Member.COL_EMAIL, kw);
        Member member = memberMapper.selectOne(qw);
        if (member != null) {
            if (member.getStatus() == 0) {
                if (member.getPassword().equals(password)) {
                    vo = new MemberVo();
                    BeanUtils.copyProperties(member, vo);
                } else {
                    throw new ServiceException(RespCode.ACCOUNT_LOGIN_ERROR);
                }
            } else {
                throw new ServiceException(RespCode.USER_ACCOUNT_LOCKED);
            }
        } else {
            throw new ServiceException(RespCode.ACCOUNT_LOGIN_ERROR);
        }
        return vo;
    }

    @Override
    public int register(MemberDto memberDto) {
        int count = 0;
        Member member = memberMapper.selectByUsername(memberDto.getUsername());
        Member member1 = memberMapper.selectByPhone(memberDto.getPhone());
        Member member2 = memberMapper.selectByEmail(memberDto.getEmail());
        if (member == null && member1 == null && member2 == null) {
            count = memberMapper.insert(memberDto);
        }
        if (member != null) {
            throw new ServiceException(RespCode.ACCOUNT_IS_EXISTENT);
        }
        if (member1 != null) {
            throw new ServiceException(RespCode.PHONE_IS_EXIST);
        }
        if (member2 != null) {
            throw new ServiceException(RespCode.EMAIL_IS_EXIST);
        }
        return count;
    }
}