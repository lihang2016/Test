package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 重写BasicErrorController,主要负责系统的异常页面的处理以及错误信息的显示
 *
 * @author lihang
 * @version 2017/5/29 11:22
 * @see org.springframework.boot.autoconfigure.web.BasicErrorController
 * @see org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration
 * @since JDK 7.0+
 */

@RequestMapping(value = "error")
@EnableConfigurationProperties({ServerProperties.class})
@Controller
public class ExceptionController extends BasicErrorController {
    @Autowired
    public ExceptionController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    public ExceptionController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    /**
     * 覆盖默认的Json响应
     */
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);
        System.out.println("自定义异常进来成功");

        //输出自定义的Json格式
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        map.put("message", "未知的请求错误");

        return new ResponseEntity<Map<String, Object>>(map, status);
    }
}
