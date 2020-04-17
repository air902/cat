package com.chedilong.event.entity;

import java.math.BigDecimal;

/**
 * 用户的实体类
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private BigDecimal balance;
    private String status;

    public User(Integer id, String name, String password, BigDecimal balance, String status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.status = status;
    }

    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
