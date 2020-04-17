package com.chedilong.event.entity;

/**
 * 订单的实体类
 */
public class Order {
    private Integer id;
    private Integer userID;
    private Integer competitionID;

    public Order(Integer id, Integer userID, Integer competitionID) {
        this.id = id;
        this.userID = userID;
        this.competitionID = competitionID;
    }

    public Order(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(Integer competitionID) {
        this.competitionID = competitionID;
    }
}
