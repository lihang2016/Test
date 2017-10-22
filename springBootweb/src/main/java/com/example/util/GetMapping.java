package com.example.util;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 13:16 2017/7/17
 */
@Target(METHOD)
@Retention(RUNTIME)
@Documented
@RequestMapping(method = GET)
public @interface GetMapping {
    @AliasFor(annotation = RequestMapping.class, attribute = "value")
    String[] value() default {};
}
