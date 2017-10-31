package com.example.member.domain.service;

import com.example.dto.NULL;
import com.example.dto.PageRequest;
import com.example.exception.CPBusinessException;
import com.example.member.app.dto.LoginDto;
import com.example.member.app.service.MemberAppService;
import com.example.member.domain.entity.Member;
import com.example.member.domain.enums.Sex;
import com.example.member.domain.repository.MemberRepository;
import com.example.member.domain.repository.MybatisMapperRepository;
import com.example.util.DomainService;
import com.example.util.event.EventBus;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.*;

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

    public Page<Member> findById(PageRequest<NULL> pageRequest){
//        List<Member> memberList=mybatisMapperRepository.find("EQ_sex",Sex.MAN.getCode());
//        List<Member> memberList1=mybatisMapperRepository.listMember(sex);
        Member member=new Member();
        member.setAddress("aaaa");
        member.setId(2L);
        mybatisMapperRepository.update(member);
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        Map<String,Object> map= Maps.newHashMap();
        map.put("EQ_sex",Sex.MAN.getCode());

        List<Member> members=mybatisMapperRepository.findAll(map,sort);


        return mybatisMapperRepository.findAllPage(pageRequest.getMap(),pageRequest.getPageable());
    }

}
