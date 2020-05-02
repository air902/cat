package com.chedilong.event.service.impl;

import com.chedilong.event.dao.ManagerDao;
import com.chedilong.event.dao.PlayerDao;
import com.chedilong.event.dao.impl.ManagerDaoImpl;
import com.chedilong.event.dao.impl.PlayerDaoImpl;
import com.chedilong.event.entity.Manager;
import com.chedilong.event.entity.Player;
import com.chedilong.event.service.ManagerService;

import java.util.ArrayList;
import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    /**
     * 战队管理层和超级管理员登录
     *
     * @param name
     * @param password
     * @param rank
     * @return
     */
    @Override
    public Manager login(String name, String password, String rank) {
        List<Object> message = new ArrayList<>();
        Manager result = null;
        message.add(name);
        message.add(password);
        message.add(rank);
        String sql = "selste * from player where account = ? and password = ? and rank = ?";
        ManagerDao managerDao = new ManagerDaoImpl();
        List<Manager> list = managerDao.userFind(sql,message);
        if(list.size()>0){
            result = list.get(0);
        }
        return result;
    }
}
