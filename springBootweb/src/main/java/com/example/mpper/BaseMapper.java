package com.example.mpper;

import com.example.domain.entity.AggEntity;
import com.example.mybatisMapper.InsterListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author lihang 【962309372@qq.com】
 * @Description:mybatis 通用mapper
 * @Date 2017/10/21 13:33
 */
public interface BaseMapper<T extends AggEntity> extends Mapper<T>,InsterListMapper<T> {
}
