package com.example.config;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 16:23 2017/12/14
 */
@Component("baseCacheKeyGenerator")
public class CacheKeyGenerator implements KeyGenerator {


    @Override
    public Object generate(Object target, Method method, Object... params) {
        Object key=new BaseCacheKey(target,method,params);
        return key.toString();
    }
}