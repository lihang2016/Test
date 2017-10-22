package com.example.member.domain.repository;

import com.example.dao.BaseRepository;
import com.example.member.domain.entity.Member;

/**
 * Created by 96230 on 2017/6/10.
 */
public interface MemberRepository extends BaseRepository<Member,Long> {
    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    Member findByPhoneAndPassWord(String phone,String password);

}
