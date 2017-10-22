package com.example.controller;

import com.example.dto.ViewInfo;
import com.example.member.app.dto.LoginDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 96230 on 2017/6/10.
 */
@RestController
public class MealController {


    /**
     * 查询全部套餐
     * @return
     */
    @RequestMapping(value="/backend/findMeal.json")
    @RequiresPermissions("权限添加")//权限管理;
    public ViewInfo findAll(){
        System.out.println(SecurityUtils.getSubject().isAuthenticated()+"MealController中的");
        return null;
    }

    /**
     * 根据套餐id查询项目---包括套餐信息
     * @param id
     * @return
     */
    @RequestMapping(value="/findById.json")
    public ViewInfo findById(Long id){
        System.out.println(SecurityUtils.getSubject().isAuthenticated());
        return null;

    }

    /**
     * 登录
     * @param loginDto
     * @return
     */
    @RequestMapping(value = "/loginName.json")
    public ViewInfo findByPhoneAndPassWord(LoginDto loginDto){
        Subject subject = SecurityUtils.getSubject();

//        SingleResponse<Long> memberId=memberAppService.findByPhoneAndPassword(loginDto);
        UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getPhone(),loginDto.getPassword(),true);
        subject.login(token);
        return new ViewInfo();
    }

    @RequestMapping(value = "/backend/testback.json")
    public String testBackEnd(){
        return "后台";
    }

}
