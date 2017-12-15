package com.example.controller;

import com.example.dto.ListRequest;
import com.example.dto.Null;
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
    public ViewInfo queryPersonTwo(PageRequest<Null> s){
         return memberAppService.findById(s).to();
    }

    @RequestMapping(value = "/testEnum",method = RequestMethod.GET)
    public ViewInfo testEnum(LoginDto LoginDto){
        return new  ViewInfo();
    }
    @RequestMapping(value = "/testValia",method = RequestMethod.GET)
    public ViewInfo queryTest(LoginDto loginDto){
        return ViewInfo.from(memberAppService.findByPhoneAndPassword(loginDto));
    }

    @RequestMapping(value = "/testListResult",method = RequestMethod.GET)
    public ViewInfo testListResult(ListRequest<Null> listRequest){
        return memberAppService.findByxxx(listRequest).to();
    }


    @RequestMapping(value = "/testRedis",method = RequestMethod.GET)
    public ViewInfo testRedis(Long id){
        return memberAppService.findByRedis(id).to();
    }

    @RequestMapping(value = "/findByClear",method = RequestMethod.GET)
    public ViewInfo findByClear(LoginDto loginDto){
        return memberAppService.findByClear(loginDto).to();
    }

    @RequestMapping(value = "/front/testfront.json")
    public String testFront(){
        return "前台";
    }
}
