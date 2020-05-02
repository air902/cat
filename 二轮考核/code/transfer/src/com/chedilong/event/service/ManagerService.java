package com.chedilong.event.service;

import com.chedilong.event.entity.Manager;
import com.chedilong.event.entity.Player;

public interface ManagerService {
    /**
     * 战队管理层和超级管理员登录
     * @param name
     * @param password
     * @param rank
     * @return
     */
    Manager login(String name, String password, String rank);
}
