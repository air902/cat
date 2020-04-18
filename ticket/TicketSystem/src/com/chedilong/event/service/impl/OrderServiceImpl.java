package com.chedilong.event.service.impl;

import com.chedilong.event.dao.CompetitionDao;
import com.chedilong.event.dao.OrderDao;
import com.chedilong.event.dao.impl.CompetitionDaoImpl;
import com.chedilong.event.dao.impl.OrderDaoImpl;
import com.chedilong.event.entity.Competition;
import com.chedilong.event.entity.User;
import com.chedilong.event.service.OrderService;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


public class OrderServiceImpl implements OrderService {
    /**
     * 用户预订赛事
     * @param loginUser
     * @param competition
     * @return
     */
    @Override
    public User orderAdd(User loginUser, Competition competition) {
        OrderDao orderDao = new OrderDaoImpl();
        BigDecimal balance = loginUser.getBalance();
        BigDecimal price = competition.getPrice();
        //判断用户是否已经预定该赛事
        Boolean reserve = orderDao.isReserved(loginUser.getId(),competition.getId());
        if(reserve){
            return null;
        }
        //判断用户的余额是否大于等于票的价格
        int sign = balance.compareTo(price);
        if(sign == 1||sign == 0){
            BigDecimal money = balance.subtract(price);
            loginUser.setBalance(money);
            Boolean result = orderDao.orderAdd(loginUser.getId(),loginUser.getBalance(),competition.getId());
            if(result){
                return loginUser;
            }else{
                return null;
            }
        }
        return null;
    }

    /**
     * 查询用户的全部订单
     * @param userId
     * @return
     */
    @Override
    public List<Competition> orderSearch(Integer userId) {
        OrderDao orderDao = new OrderDaoImpl();
        CompetitionDao competitionDao = new CompetitionDaoImpl();
        List<Competition> competitionList = new LinkedList<>();
        //获取用户预约的全部赛事id
        List<Integer> competitionIdList = orderDao.orderSearch(userId);
        if(competitionIdList.size() == 0){
            return null;
        }else{
            competitionList = competitionDao.competitionSearch(competitionIdList);
            return competitionList;
        }
    }

    /**
     * 用户取消赛事
     * @param loginUser
     * @param competition
     * @return
     */
    @Override
    public User orderCancel(User loginUser, Competition competition) {
        OrderDao orderDao = new OrderDaoImpl();
        //退还用户购票钱款
        BigDecimal money = loginUser.getBalance().add(competition.getPrice());
        loginUser.setBalance(money);
        Boolean result = orderDao.orderCancel(loginUser.getId(),loginUser.getBalance(),competition.getId());
        if(result){
            return loginUser;
        }else{
            return null;
        }
    }
}
