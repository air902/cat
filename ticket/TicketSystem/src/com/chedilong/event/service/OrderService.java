package com.chedilong.event.service;

import com.chedilong.event.entity.Competition;
import com.chedilong.event.entity.User;

import java.util.List;

public interface OrderService {
    /**
     * 用户预订赛事
     * @param loginUser
     * @param competition
     * @return
     */
    User orderAdd(User loginUser, Competition competition);

    /**
     * 查询用户的全部订单
     * @param userId
     * @return
     */
    List<Competition> orderSearch(Integer userId);
}
