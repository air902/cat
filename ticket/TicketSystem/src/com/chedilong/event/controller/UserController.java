package com.chedilong.event.controller;

import com.chedilong.event.entity.User;
import com.chedilong.event.service.UserService;
import com.chedilong.event.service.impl.UserServiceImpl;

import java.math.BigDecimal;

public class UserController {
    /**
     * 用户登录
     *
     * @param userTxt
     * @return
     */
    public User login(User userTxt) {
        UserService userService = new UserServiceImpl();
        User result = userService.login(userTxt);
        return  result;
    }

    /**
     * 用户注册
     *
     * @param userTxt
     * @return
     */
    public Boolean register(User userTxt) {
        UserService userService = new UserServiceImpl();
        Boolean result = userService.register(userTxt);
        return  result;
    }

    /**
     * 用户个人信息修改
     * @param userTxt
     * @return
     */
    public User inFoUpdate(User userTxt,User loginUser) {
        UserService userService = new UserServiceImpl();
        User result = userService.inFoUpdate(userTxt,loginUser);
        return  result;
    }

    /**
     * 用户账户充值
     * @param loginUser 要充值的账户
     * @param money 要充值的金额
     * @return
     */
    public User userRecharge(User loginUser, BigDecimal money) {
        UserService userService = new UserServiceImpl();
        User result = userService.userRecharge(loginUser,money);
        return result;
    }
}
