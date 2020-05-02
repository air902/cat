package com.chedilong.event.dao.impl;

import com.chedilong.event.dao.UserDao;
import com.chedilong.event.entity.User;
import com.chedilong.event.util.DatabaseConnectionUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl  implements UserDao {

    /**
     * 用户登录时检验用户信息
     * @param userTxt
     * @return
     */
    @Override
    public User login(User userTxt) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User result = null;
        //核对用户登录信息
        String sql = "select * from user where name = ? and password = ? and status = ? for update";
        try {
            con = DatabaseConnectionUtil.getConnection();
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, userTxt.getName());
                pstmt.setString(2, userTxt.getPassword());
                pstmt.setString(3, userTxt.getStatus());
            rs = pstmt.executeQuery();
            if(rs.next()){
                result = new User();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setPassword(rs.getString("password"));
                result.setBalance(rs.getBigDecimal("balance"));
                result.setStatus(rs.getString("status"));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,rs);
        }
    }

    /**
     * 查询该用户名是否已经被注册
     * @param userTxt
     * @return User:可能该用户名被注册    null：该用户名未被注册
     */
    @Override
    public Boolean isRepetition(User userTxt) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //查询数据库中是否存在该用户名的用户信息
        String sql = "select * from user where name = ? for update";
        try {
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userTxt.getName());
            rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,rs);
        }
    }

    /**
     * 用户注册
     * @param userTxt
     * @return
     */
    @Override
    public Boolean register(User userTxt) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "insert into user(name,password,balance,status) values(?,?,?,?)";
        try {
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userTxt.getName());
            pstmt.setString(2, userTxt.getPassword());
            pstmt.setBigDecimal(3, BigDecimal.valueOf(0));
            pstmt.setString(4,userTxt.getStatus());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,null);
        }
    }

    /**
     * 用户余额充值
     * @param userTxt
     * @return
     */
    @Override
    public User rechargeBalance(User userTxt) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "update user set balance = ? where id = ?";
        try {
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setBigDecimal(1, userTxt.getBalance());
            pstmt.setInt(2,userTxt.getId());
            pstmt.executeUpdate();
            return userTxt;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,null);
        }
    }

    /**
     * 用户个人信息修改
     * @param userTxt 要修改的用户信息
     * @return
     */
    @Override
    public User inFoUpdate(User userTxt) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "update user set name = ?,password = ? where id = ?";
        try {
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, userTxt.getName());
            pstmt.setObject(2,userTxt.getPassword());
            pstmt.setObject(3,userTxt.getId());
            pstmt.executeUpdate();
            return userTxt;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,null);
        }
    }
}
