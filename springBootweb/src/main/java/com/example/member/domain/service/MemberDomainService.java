package com.example.member.domain.service;

import com.example.dto.ListRequest;
import com.example.dto.Null;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import java.util.List;
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

    public Page<Member> findById(PageRequest<Null> pageRequest){
        return mybatisMapperRepository.findAllPage(pageRequest.getMap(),pageRequest.getPageable());
    }

    public List<Member> findxx(ListRequest<Null> listRequest){
        List<Member> list=mybatisMapperRepository.findAll(listRequest.getMap(),listRequest.getSort());
        System.out.println(list);
        return list;
    }

    @Cacheable(value = "Member",key = "#id")
    public Member findByRedis(Long id){
       return mybatisMapperRepository.get(id);
    }
}
