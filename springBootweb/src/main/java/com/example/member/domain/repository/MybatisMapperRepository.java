package com.example.member.domain.repository;

import com.example.member.domain.entity.Member;
import com.example.member.domain.enums.Sex;
import com.example.mpper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.*;

/**
 * @Author lihang 【962309372@qq.com】
 * @Description
 * @Date 2017/10/21 13:39
 */
public interface MybatisMapperRepository extends BaseMapper<Member> {

    @Select("select * from member m")
    List<Member>  listMember(@Param("sex") Sex sex);

}
