package com.example.controller;


import com.example.domain.app.service.PersonAppService;
import com.example.dto.PageDto;
import com.example.dto.ViewInfo;
//import com.lihang.spring_boot_starter_hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by 96230 on 2017/4/17.
 */
@RestController
public class Controller {


    @Autowired
    PersonAppService personAppService;


//    @RequestMapping("/q1")
//    public Page<Person> findByName(PersonDto personDto){
//        Page<Person> people=personRepository.findByName(personDto.getName(),new PageRequest(personDto.getSize(),personDto.getPage()));
//        return people;
//    }

    @RequestMapping(value = "/q3",method = RequestMethod.GET)
    public ViewInfo queryPersonTwo(PageDto pageDto){
        return ViewInfo.from(personAppService.queryListPersonTwo(pageDto));
    }

}
