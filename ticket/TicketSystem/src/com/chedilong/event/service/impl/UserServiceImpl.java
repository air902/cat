package com.chedilong.event.service.impl;

import com.chedilong.event.dao.UserDao;
import com.chedilong.event.dao.impl.UserDaoImpl;
import com.chedilong.event.entity.User;
import com.chedilong.event.service.UserService;

import java.math.BigDecimal;

public class UserServiceImpl implements UserService {
    /**
     * 用户登录
     * @param userTxt
     * @return
     */
    @Override
    public User login(User userTxt) {
        UserDao userDao = new UserDaoImpl();
        User result = userDao.login(userTxt);
        return  result;
    }

    /**
     * 用户注册
     * @param userTxt
     * @return
     */
    @Override
    public Boolean register(User userTxt) {
        UserDao userDao = new UserDaoImpl();
        //判断该用户名是否被注册
        Boolean sign = userDao.isRepetition(userTxt);
        if(sign){
            return false;
        }else{
            boolean result = userDao.register(userTxt);
            return result;
        }

    }

    /**
     * 用户个人信息更新
     * @param userTxt 修改后的用户信息
     * @param loginUSer
     * @return
     */
    @Override
    public User inFoUpdate(User userTxt,User loginUSer) {
        UserDao userDao = new UserDaoImpl();
        //判断用户是否修改用户名
        if(!userTxt.getName().equals(loginUSer.getName())){
            //判断修改后的用户名是否被注册
            boolean sign = userDao.isRepetition(userTxt);
            if (sign){
                return null;
            }
        }
        User result = userDao.inFoUpdate(userTxt);
        return result;
    }

    /**
     * 用户账户充值
     * @param user 要充值的账户
     * @param money 充值金额
     * @return
     */
    @Override
    public User userRecharge(User user, BigDecimal money) {
        UserDao userDao = new UserDaoImpl();
        //将用户充值金额加到user的balance上
        BigDecimal userMoney;
        userMoney = user.getBalance().add(money);
        user.setBalance(userMoney);
        //更新数据库中用户余额信息
        User result = userDao.rechargeBalance(user);
        return result;
    }


}
