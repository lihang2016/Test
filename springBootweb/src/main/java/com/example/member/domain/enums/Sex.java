package com.example.member.domain.enums;

import com.example.Annto.Enums;

/**
 * @Author lihang 【962309372@qq.com】
 * @Description
 * @Date 2017/10/22 11:07
 */
@Enums
public enum  Sex {

    MAN("MAN","男"),
    WOMAN("WOMAN","女");

    private String msg;

    private String code;

    Sex(String code,String msg){
        this.msg=msg;
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
