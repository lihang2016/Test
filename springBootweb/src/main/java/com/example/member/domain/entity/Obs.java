package com.example.member.domain.entity;

import com.example.domain.entity.AggEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author:lihang
 * @Description:文件
 * @Date Create in 17:04 2017/12/13
 */

@Entity
@Table(name="obs")
@Getter
@Setter
public class Obs extends AggEntity {
    @Column(name="fileName",columnDefinition = "varchar(200) not null comment '文件名称'")
    private String fileName;

    @Column(name="fileSize",columnDefinition = "int(11) not null comment '文件大小'")
    private Long fileSize;

    @Column(name="meta",columnDefinition = "varchar(500) not null comment '文件属性'")
    private String meta;

    @Column(name="providerId",columnDefinition = "varchar(500) not null comment '文件路径'")
    private String providerId;
}
