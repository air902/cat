package com.chedilong.event.dao.impl;

import com.chedilong.event.dao.PlayerDao;
import com.chedilong.event.entity.Player;
import com.chedilong.event.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {
    /**
     * 用户的增删改操作
     * @param sql
     * @param message
     * @return
     */
    @Override
    public int userCud(String sql, List<Object> message) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            //给占位符赋值
            for(int i = 0;i<message.size();i++){
                Object object = message.get(i);
                pstmt.setObject(i+1, object);
            }
            return pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,null);
        }
    }

    /**
     * 玩家的查询
     * @param sql
     * @param message
     * @return
     */
    @Override
    public List<Player> userFind(String sql, List<Object> message) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Player> result = new ArrayList<>();
        try {
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            //给占位符赋值
            for (int i = 0; i < message.size(); i++) {
                Object object = message.get(i);
                pstmt.setObject(i + 1, object);
            }
            rs = pstmt.executeQuery();
            while (rs != null) {
                //封装获取到的玩家信息
                Player player = new Player(
                        rs.getInt("id"),
                        rs.getString("account"),
                        null,
                        rs.getString("portrait"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("introduction"),
                        rs.getString("lastTeam"),
                        rs.getString("joinDate"),
                        rs.getString("email"),
                        rs.getString("accountStatus"),
                        rs.getString("teamStatus"),
                        rs.getString("rank"));
                result.add(player);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnectionUtil.close(con, pstmt, rs);
        }
    }
}
