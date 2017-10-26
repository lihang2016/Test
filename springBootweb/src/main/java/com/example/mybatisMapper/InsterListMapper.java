package com.example.mybatisMapper;
import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 10:14 2017/10/26
 */
public interface InsterListMapper<T> extends Mapper<T> {

    @InsertProvider(type = InsterDemoMapper.class, method = "dynamicSQL")
    int instartList();
}
