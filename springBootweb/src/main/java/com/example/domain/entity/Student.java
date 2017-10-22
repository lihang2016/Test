package com.example.domain.entity;

import javax.persistence.*;

/**
 * Created by 96230 on 2017/5/29.
 */
public class Student extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="student_age",columnDefinition = "int(3) not null comment '学生年龄'")
    private Integer studentAge;

    @Column(name="person_id",columnDefinition = "int(11) not null comment '人的id'")
    private Long personId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
