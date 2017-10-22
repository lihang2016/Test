package com.example.config;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 17:15 2017/7/24
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("进来了+“1111111111111");
        return super.onAccessDenied(request, response);
    }
}
