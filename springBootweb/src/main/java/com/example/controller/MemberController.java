package com.example.controller;

import com.example.dto.NULL;
import com.example.dto.PageRequest;
import com.example.dto.ViewInfo;
import com.example.member.app.dto.LoginDto;
import com.example.member.app.service.MemberAppService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员controller
 * Created by 96230 on 2017/6/10.
 */
@RestController
public class MemberController {
    @Autowired
    private MemberAppService memberAppService;

    /**
     * 登录
     * @param loginDto
     * @return
     */
    @RequestMapping(value = "/login.json")
    public ViewInfo findByPhoneAndPassWord(LoginDto loginDto){
        Subject subject = SecurityUtils.getSubject();

//        SingleResponse<Long> memberId=memberAppService.findByPhoneAndPassword(loginDto);
        UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getPhone(),loginDto.getPassword());
        token.setRememberMe(true);
        subject.login(token);
        return new ViewInfo();
    }
    @RequestMapping(value = "/testMybatis",method = RequestMethod.GET)
    public ViewInfo queryPersonTwo(PageRequest<NULL> s){
         return ViewInfo.from(memberAppService.findById(s));
    }

    @RequestMapping(value = "/testValia",method = RequestMethod.GET)
    public ViewInfo queryTest(LoginDto loginDto){
        return ViewInfo.from(memberAppService.findByPhoneAndPassword(loginDto));
    }

    @RequestMapping(value = "/front/testfront.json")
    public String testFront(){
        return "前台";
    }
}
