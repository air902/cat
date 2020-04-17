package com.chedilong.event.entity;

import java.math.BigDecimal;

/**
 * 赛事的实体类
 */
public class Competition {
    private Integer id;
    private String homeField;
    private String visitingField;
    private String introduction;
    private String time;
    private BigDecimal price;

    public Competition(Integer id, String homeField, String visitingField, String introduction, String time, BigDecimal price) {
        this.id = id;
        this.homeField = homeField;
        this.visitingField = visitingField;
        this.introduction = introduction;
        this.time = time;
        this.price = price;
    }

    public Competition(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHomeField() {
        return homeField;
    }

    public void setHomeField(String homeField) {
        this.homeField = homeField;
    }

    public String getVisitingField() {
        return visitingField;
    }

    public void setVisitingField(String visitingField) {
        this.visitingField = visitingField;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
