package com.chedilong.event.dao;

import com.chedilong.event.entity.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDao {
    /**
     * 添加用户预订信息
     * @param userID
     * @param balance 用户预定赛事后余额
     * @param competitionID
     * @return
     */
    Boolean orderAdd(Integer userID, BigDecimal balance,Integer competitionID);

    /**
     * 查询用户所有订单信息
     * @param userID
     * @return
     */
    List<Integer> orderSearch(Integer userID);

    /**
     * 检查用户是否预定该赛事
     * @param userID
     * @param competitionID
     * @return
     */
    Boolean isReserved(Integer userID,Integer competitionID);

    /**
     * 用户取消订单信息
     * @param userID
     * @param balance 用户预定赛事后余额
     * @param competitionID
     * @return
     */
    Boolean orderCancel(Integer userID, BigDecimal balance,Integer competitionID);
}
