package com.example.member.domain.service;

import com.example.exception.CPBusinessException;
import com.example.member.app.dto.LoginDto;
import com.example.member.app.service.MemberAppService;
import com.example.member.domain.entity.Member;
import com.example.member.domain.repository.MemberRepository;
import com.example.member.domain.repository.MybatisMapperRepository;
import com.example.util.DomainService;
import com.example.util.event.EventBus;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 会员领域服务
 * Created by 96230 on 2017/6/10.
 */
@DomainService
public class MemberDomainService {

    @Autowired
    private MemberRepository memberRepository;



    @Autowired
    private MemberAppService memberAppService;

    @Autowired
    private EventBus eventBus;

    @Autowired
    private MybatisMapperRepository mybatisMapperRepository;
    /**
     * 登录
     * @param loginDto
     * @return
     */
    public Member findByPhoneAndPassword(LoginDto loginDto){
        Member member=memberRepository.findByPhoneAndPassWord(loginDto.getPhone(),loginDto.getPassword());
        if(member==null){
            CPBusinessException.throwIt("账号或者密码不正确",444);
        }
        return member;
    }

    public Page<Member> findById(Long id){
       // Member member=mybatisMapperRepository.selectByPrimaryKey(1L);
       // mybatisMapperRepository.instartList();
        Map<String,Object> map= Maps.newHashMap();
        map.put("LIKE_memberName","小白");
        Pageable pageable=new PageRequest(1,1);
        Page<Member> member=mybatisMapperRepository.findAllPage(map,pageable);
//        List<Member> member=mybatisMapperRepository.find("LIKE_memberName","小白");
        System.out.println("aaaaa");
        return member;
    }

}
