package com.chedilong.event.controller;

import com.chedilong.event.entity.Competition;
import com.chedilong.event.entity.User;
import com.chedilong.event.service.OrderService;
import com.chedilong.event.service.impl.OrderServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class OrderController {
    /**
     * 用户预定赛事
     * @param loginUser
     * @param competition
     * @return
     */
    public User orderAdd(User loginUser, Competition competition){
        OrderService orderService = new OrderServiceImpl();
        User result = orderService.orderAdd(loginUser,competition);
        return result;
    }

    /**
     * 查询用户的全部订单
     * @param userId
     * @return
     */
    public List<Competition> orderSearch(Integer userId){
        OrderService orderService = new OrderServiceImpl();
        List<Competition> competitionList = orderService.orderSearch(userId);
        return competitionList;
    }
}
