package com.example.member.domain.entity;

import com.example.domain.entity.AggEntity;
import com.example.member.domain.enums.Sex;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 96230 on 2017/6/10.
 */
@Entity
@Table(name="member")
public class Member extends AggEntity {


    @Column(name="member_name",columnDefinition = "varchar(40) comment '会员名称'")
    private String memberName;

    @Column(name="sex",columnDefinition = "varchar(40) comment '性别'")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name="id_card",columnDefinition = "varchar(20) comment '身份证号'")
    private String idCard;

    @Column(name="phone",columnDefinition = "varchar(15) comment '手机号码'")
    private String phone;

    @Column(name="birthday",columnDefinition = "datetime comment '出生日期'")
    private Date birthday;

    @Column(name="address",columnDefinition = "varchar(500) comment '联系地址'")
    private String address;

    @Column(name="company_name",columnDefinition = "varchar(100) comment '公司名称'")
    private String companyName;

    @Column(name="pass_word",columnDefinition = "varchar(40) comment '密码'")
    private String passWord;

    @Column(name="member_type",columnDefinition = "varchar(15) comment '会员类型'")
    private String memberType;


    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

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
}
