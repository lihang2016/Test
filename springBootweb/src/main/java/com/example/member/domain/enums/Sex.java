package com.example.member.domain.enums;

/**
 * @Author lihang 【962309372@qq.com】
 * @Description
 * @Date 2017/10/22 11:07
 */
public enum Sex {
    MAN("男","MAN"),
    WOMAN("女","WOMAN");

    private String msg;

    private String code;

    Sex(String message,String code){
        this.msg=message;
        this.code=code;
    }


}
