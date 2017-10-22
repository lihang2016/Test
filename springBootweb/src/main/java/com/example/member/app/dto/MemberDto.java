package com.example.member.app.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 14:39 2017/7/20
 */
public class MemberDto implements Serializable{

    private static final long serialVersionUID = -1383806067748513736L;

    private String memberName;


    private String idCard;

    private String phone;

    private Date birthday;

    private String address;

    private String companyName;

    private String passWord;

    private String memberType;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}
