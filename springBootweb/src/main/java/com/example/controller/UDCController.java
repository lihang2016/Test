package com.example.controller;

import com.example.common.udc.app.dto.UDCItemDto;
import com.example.common.udc.app.service.UDCItemAppService;
import com.example.common.udc.app.service.UDCTypeAppService;
import com.example.dto.SingleResponse;
import com.example.dto.ViewInfo;
import com.example.util.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Author:lihang
 * @Description:查询码表
 * @Date Create in 20:24 2017/7/6
 */
@RestController
public class UDCController {

    @Autowired
    private UDCTypeAppService udcTypeAppService;

    @GetMapping("/udc/list.json")
    public ViewInfo findUDC(@RequestParam("typeCode")String typeCode){

        SingleResponse<List<UDCItemDto>> list=udcTypeAppService.findByTypeCode(typeCode);
      return  list.convertTo();
    }
}
