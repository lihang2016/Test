package com.example.util;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 9:36 2017/7/17
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Service
public @interface AppService {
    boolean enable() default true;
}
