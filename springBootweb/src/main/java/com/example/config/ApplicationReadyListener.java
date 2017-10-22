package com.example.config;

import com.example.common.udc.UDC;
import com.example.domain.entity.BaseEntity;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 启动监听
 * Created by 96230 on 2017/6/3.
 */
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        BaseEntity.inited();
        UDC.initUdcService();
    }
}
