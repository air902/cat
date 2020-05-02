package com.chedilong.event.entity;

/**
 * 转会信息实体类
 */
public class TransferInFo {
    private Integer id;
    private Integer playerId;
    private String portrait;
    private String playerName;
    private String price;
    private String classify;
    private String status;

    public TransferInFo(Integer id, Integer playerId, String portrait, String playerName, String price, String classify, String status) {
        this.id = id;
        this.playerId = playerId;
        this.portrait = portrait;
        this.playerName = playerName;
        this.price = price;
        this.classify = classify;
        this.status = status;
    }
    public TransferInFo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
