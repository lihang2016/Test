package com.example.member.domain.entity;

import com.example.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by 96230 on 2017/6/10.
 */
@Entity
@Table(name="member_project")
public class MemberProject  extends BaseEntity{

    @Column(name="project_name",columnDefinition = "varchar(40) comment '项目名称'")
    private String projectName;

    @Column(name="project_price",columnDefinition = "decimal(26,6) comment '项目金额'")
    private BigDecimal projectPrice;

    @Column(name="decs",columnDefinition = "varchar(500) comment '项目详情'")
    private String decs;

    @Column(name="meal_id",columnDefinition = "int(11) comment '套餐id'")
    private Long mealId;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(BigDecimal projectPrice) {
        this.projectPrice = projectPrice;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }
}
