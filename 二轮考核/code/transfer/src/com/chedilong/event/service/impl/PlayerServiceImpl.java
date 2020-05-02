package com.chedilong.event.service.impl;

import com.chedilong.event.dao.PlayerDao;
import com.chedilong.event.dao.impl.PlayerDaoImpl;
import com.chedilong.event.entity.Player;
import com.chedilong.event.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

public class PlayerServiceImpl implements PlayerService {

    /**
     * 玩家登录
     *
     * @param name
     * @param password
     * @return
     */
    @Override
    public Player login(String name, String password) {
        List<Object> message = new ArrayList<>();
        Player result = null;
        message.add(name);
        message.add(password);
        String sql = "selste * from player where account = ? and password = ?";
        PlayerDao playerDao = new PlayerDaoImpl();
        List<Player> list = playerDao.userFind(sql,message);
        if(list.size()>0){
            result = list.get(0);
        }
        return result;
    }

    /**
     * 玩家注册
     *
     * @param player
     * @return
     */
    @Override
    public int register(Player player) {
        List<Object> message = new ArrayList<>();
        message.add(player.getAccount());
        message.add(player.getPassword());
        message.add(player.getPortrait());
        message.add(player.getName());
        message.add(player.getAge());
        message.add(player.getIntroduction());
        message.add(player.getLastTeam());
        message.add(player.getJoinDate());
        message.add(player.getEmail());
        message.add(player.getAccountStatus());
        message.add(player.getTeamStatus());
        message.add(player.getRank());

        String sql = "insert into player values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
        PlayerDao playerDao = new PlayerDaoImpl();
        int result = playerDao.userCud(sql,message);
        return result;
    }
}
