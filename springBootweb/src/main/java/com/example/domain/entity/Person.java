package com.example.domain.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by 96230 on 2017/4/17.
 */

public class Person  extends AggEntity{


    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name",columnDefinition = "varchar(40) not null comment '人的名称'")
    private String name;
    @Column(name="age",columnDefinition = "int(3) not null comment '人的年龄'")
    private Integer age;
    @Column(name="address",columnDefinition = "varchar(40) not null comment '人的名称'")
    private String address;


    private transient Integer  studentAge;


    private transient List<Student> studentList;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }


    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
