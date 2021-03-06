package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.util.Map;
/**
 * @Author lihang 【962309372@qq.com】
 * @Description
 * @Date 2017/10/28 12:53
 */
@Getter
@Setter
public class PageRequest<T extends Null> extends BaseDto {
    Map<String,Object> map;

    Pageable pageable;
}
