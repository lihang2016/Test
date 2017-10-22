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
@Table(name="member_meal")
public class MemberMeal extends BaseEntity {

    @Column(name="name",columnDefinition = "varchar(40) comment '套餐名称'")
    private String name;

    @Column(name="original_price",columnDefinition = "decimal(26,6) comment '套餐原价'")
    private BigDecimal originalPrice;

    @Column(name="actual_price",columnDefinition = "decimal(26,6) comment '套餐实际金额'")
    private BigDecimal actualPrice;

    @Column(name="decs",columnDefinition = "varchar(500) comment '套餐详情'")
    private String decs;

    @Column(name="member_id",columnDefinition = "int(11) comment '会员id'")
    private Long memberId;

    @Column(name="meal_sex",columnDefinition = "varchar(5) comment '套餐性别'")
    private String mealSex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMealSex() {
        return mealSex;
    }

    public void setMealSex(String mealSex) {
        this.mealSex = mealSex;
    }
}
