package com.example.member.app.service;

import com.example.dto.SingleResponse;
import com.example.member.app.dto.LoginDto;
import com.example.member.app.dto.MemberDto;
import com.example.member.domain.service.MemberDomainService;
import com.example.util.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by 96230 on 2017/6/10.
 */
@AppService
@Transactional
public class MemberAppService {

    @Autowired
    private MemberDomainService memberDomainService;

    /**
     * 登录
     * @param loginDto
     * @return
     */
    public SingleResponse<MemberDto> findByPhoneAndPassword(LoginDto loginDto){
        return SingleResponse.from(memberDomainService.findByPhoneAndPassword(loginDto).to(MemberDto.class));
    }

    public SingleResponse<MemberDto> findById(Long id){
        return SingleResponse.from(memberDomainService.findById(id).to(MemberDto.class));
    }
}
