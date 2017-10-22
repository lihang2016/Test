package com.example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 2:12 2017/7/21
 */
public class FrontWebConfigration {

    public  static CPACLFilter loginFilterRegistrationBean() {
        CPACLFilter bean = new CPACLFilter.Builder().loginUrl("/login.json")
                .notNeedLoginUrls("/front/static/assets/**","/front/product_detail.html","/front/static/css/**","/front/static/fonts/**","/front/static/img/**","/front/static/js/**")
                .urlPatterns("/front/**").supportUserType("front").build2();
//        bean.setName("front_loginFilter");
//        CPACLFilter cpaclFilter=new CPACLFilter();
//        cpaclFilter.setLoginUrl("");

        return bean;
    }
}
