package com.example.util;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 9:37 2017/7/4
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DomainService {
}
