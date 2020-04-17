package com.chedilong.event.service;

import com.chedilong.event.entity.User;

import java.math.BigDecimal;

public interface UserService {
    /**
     * 用户登录
     * @param userTxt
     * @return
     */
    User login(User userTxt);

    /**
     * 用户注册
     * @param userTxt
     * @return
     */
    Boolean register(User userTxt);

    /**
     * 用户个人信息修改
     * @param userTxt 修改后的用户信息
     * @param loginuser 修改前的用户信息
     * @return
     */
    User inFoUpdate(User userTxt,User loginuser);

    /**
     * 用户余额充值
     * @param user 要充值的账户
     * @param money 充值金额
     * @return
     */
    User userRecharge(User user, BigDecimal money);
}
