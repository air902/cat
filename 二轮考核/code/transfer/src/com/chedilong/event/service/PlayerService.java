package com.chedilong.event.service;

import com.chedilong.event.entity.Player;

public interface PlayerService {
    /**
     * 玩家登录
     * @param name
     * @param password
     * @return
     */
    Player login(String name, String password);

    /**
     * 玩家注册
     * @param player
     * @return
     */
    int register(Player player);
}
