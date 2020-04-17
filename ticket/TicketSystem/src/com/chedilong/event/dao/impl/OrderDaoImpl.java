package com.chedilong.event.dao.impl;

import com.chedilong.event.dao.OrderDao;
import com.chedilong.event.entity.Order;
import com.chedilong.event.util.DatabaseConnectionUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    /**
     * 添加用户预订信息
     * @param userID
     * @param balance 用户预定赛事后余额
     * @param competitionID
     * @return
     */
    @Override
    public Boolean orderAdd(Integer userID, BigDecimal balance,Integer competitionID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        //往赛事表中添加用户预订信息
        String sql1 = "INSERT INTO `order` (`userID`,`competitionID`) VALUES(?,?)";
        //修改用户账户余额
        String sql2 = "update user set balance = ? where id = ?";
        try {
            con = DatabaseConnectionUtil.getConnection();
            con.setAutoCommit(false);
            //往赛事表中添加用户预订信息
            pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1,userID);
            pstmt.setInt(2, competitionID);
            pstmt.executeUpdate();
            //修改用户账户余额
            pstmt = con.prepareStatement(sql2);
            pstmt.setBigDecimal(1,balance);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
            con.commit();
            return true;
        } catch (SQLException e) {
            //发生异常，回滚事务
            if(con != null){
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            return false;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,null);
        }
    }

    /**
     * 查询用户所有订单信息
     * @param userID
     * @return
     */
    @Override
    public List<Integer> orderSearch(Integer userID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Integer> competitionIdList = new ArrayList<>();
        String sql = "select * from `order` where `userID` = ?";
        try {
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,userID);
            rs = pstmt.executeQuery();
            while(rs.next()){
                competitionIdList.add(rs.getInt("competitionID"));
            }
            return competitionIdList;
        } catch (SQLException e) {
            e.printStackTrace();
            return competitionIdList;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,rs);
        }
    }

    /**
     * 检查用户是否预定该赛事
     * @param userID
     * @param competitionID
     * @return
     */
    @Override
    public Boolean isReserved(Integer userID, Integer competitionID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from2 `order` where `userID` = ? and `competitionID` = ?";
        try {
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,userID);
            pstmt.setInt(2,competitionID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,rs);
        }
    }
}
