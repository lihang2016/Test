package com.example.member.domain.enums;

import com.example.webconverter.Messageable;

/**
 * @Author lihang 【962309372@qq.com】
 * @Description
 * @Date 2017/10/22 11:07
 */
public enum  Sex implements Messageable{

    MAN("MAN","男"),
    WOMAN("WOMAN","女");

    private String msg;

    private String code;

    Sex(String code,String msg){
        this.msg=msg;
        this.code=code;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return msg;
    }
}
