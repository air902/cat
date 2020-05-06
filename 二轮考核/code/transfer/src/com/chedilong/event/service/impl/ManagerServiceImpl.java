package com.chedilong.event.service.impl;

import com.chedilong.event.dao.ManagerDao;
import com.chedilong.event.dao.impl.ManagerDaoImpl;
import com.chedilong.event.entity.Manager;
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
        String sql = "select * from `manager` where account = ? and password = ?";
        ManagerDao managerDao = new ManagerDaoImpl();
        List<Manager> list = managerDao.userFind(sql,message);
        if(list.size()>0){
            result = list.get(0);
        }
        return result;
    }

    /**
     * 战队管理层注册
     * @param manager
     * @return
     */
    @Override
    public int register(Manager manager) {
        List<Object> message = new ArrayList<>();
        message.add(manager.getAccount());
        message.add(manager.getPassword());
        message.add(manager.getPortrait());
        message.add(manager.getName());
        message.add(manager.getAge());
        message.add(manager.getRank());
        message.add(0);
        message.add(manager.getTeam());

        String sql = "insert into player values(null,?,?,?,?,?,?,?,?)";
        ManagerDao managerDao = new ManagerDaoImpl();
        int result = managerDao.userCud(sql,message);
        return result;
    }
}
