package com.chedilong.event.entity;

/**
 * 管理员实体表
 */
public class Manager {
    private Integer id;
    private String account;
    private String password;
    private String portrait;
    private String name;
    private String age;
    private String rank;
    private String amount;

    public Manager(Integer id, String account, String password, String portrait, String name, String age, String rank, String amount) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.portrait = portrait;
        this.name = name;
        this.age = age;
        this.rank = rank;
        this.amount = amount;
    }
    public Manager(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
