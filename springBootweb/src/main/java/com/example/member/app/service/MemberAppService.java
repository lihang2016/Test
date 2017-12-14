package com.example.member.app.service;

import com.example.dto.*;
import com.example.member.app.dto.LoginDto;
import com.example.member.app.dto.MemberDto;
import com.example.member.domain.entity.Member;
import com.example.member.domain.service.MemberDomainService;
import com.example.util.AppService;
import com.example.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        return SingleResponse.from(memberDomainService.findByPhoneAndPassword(loginDto),MemberDto.class);
    }

    public PageResult<MemberDto> findById(PageRequest<Null> pageRequest){
        return PageResult.from(memberDomainService.findById(pageRequest),MemberDto.class);
    }

    public ListResult<MemberDto> findByxxx(ListRequest<Null> listRequest){
        return ListResult.from(memberDomainService.findxx(listRequest),MemberDto.class);
    }

    public SingleResponse<MemberDto> findByRedis(Long id){
        return SingleResponse.from(memberDomainService.findByRedis(id), MemberDto.class);
    }
}
