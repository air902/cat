package com.chedilong.event.dao;

import com.chedilong.event.entity.User;

public interface UserDao {
    /**
     * 用户登录时检验用户信息
     * @param userTxt
     * @return
     */
    User login(User userTxt);

    /**
     * 查询该用户名是否已经被注册
     * @param userTxt
     * @return
     */
    Boolean isRepetition(User userTxt);

    /**
     * 用户注册
     * @param userTxt
     * @return
     */
    Boolean register(User userTxt);

    /**
     * 用户余额充值
     * @param userTxt
     * @return
     */
    User rechargeBalance(User userTxt);

    /**
     * 用户个人信息更新
     * @param userTxt 要修改的用户信息
     * @return
     */
    User inFoUpdate(User userTxt);
}
