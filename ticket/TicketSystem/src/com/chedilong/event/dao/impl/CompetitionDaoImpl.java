package com.chedilong.event.dao.impl;

import com.chedilong.event.dao.CompetitionDao;
import com.chedilong.event.entity.Competition;
import com.chedilong.event.util.DatabaseConnectionUtil;
import com.chedilong.event.util.StringJudgeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDaoImpl implements CompetitionDao {
    /**
     * 根据输入查询比赛信息
     * @param teamName
     * @return
     */
    @Override
    public List<Competition> competitionSearch(String teamName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Competition> competitions = new ArrayList<>();
        //用户不输入信息时查询所有比赛
        String sql1 = "select * from competition";
        //查询主场战队
        String sql2 = "select * from competition where homeField like ?";
        //查询客场战队
        String sql3 = "select * from competition where visitingField like ?";
        List<String> sqlList = new ArrayList<>();
        sqlList.add(sql2);
        sqlList.add(sql3);
        try {
            con = DatabaseConnectionUtil.getConnection();
            if(StringJudgeUtil.isEmpty(teamName)){
                //查询全部比赛信息
                pstmt = con.prepareStatement(sql1);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Competition competition = new Competition(rs.getInt("id"),rs.getString("homeField"),
                            rs.getString("visitingField"),rs.getString("introduction"),
                            rs.getString("time"),rs.getBigDecimal("price"));
                    competitions.add(competition);
                }
            }else{
                //分别查询主客场
                for(int i = 0;i < sqlList.size();i++){
                    pstmt = con.prepareStatement(sqlList.get(i));
                    pstmt.setString(1,"%"+teamName+"%");
                    rs = pstmt.executeQuery();
                    while(rs.next()){
                        Competition competition = new Competition(rs.getInt("id"),rs.getString("homeField"),
                                rs.getString("visitingField"),rs.getString("introduction"),
                                rs.getString("time"),rs.getBigDecimal("price"));
                        competitions.add(competition);
                    }
                }
            }
            return competitions;
        } catch (SQLException e) {
            e.printStackTrace();
            return competitions;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,rs);
        }
    }

    /**
     * 查询用户个人预约比赛
     * @param competitionIDList 用户预约的比赛idList
     * @return
     */
    @Override
    public List<Competition> competitionSearch(List<Integer> competitionIDList) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Competition> competitions = new ArrayList<>();
        String sql = "select * from competition where id = ?";
        try {
            con = DatabaseConnectionUtil.getConnection();
            //获取用户预订的所有赛事信息
            for(int i = 0;i<competitionIDList.size();i++){
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1,competitionIDList.get(i));
                rs = pstmt.executeQuery();
                rs.next();
                Competition competition = new Competition(rs.getInt("id"),rs.getString("homeField"),
                                          rs.getString("visitingField"),rs.getString("introduction"),
                                          rs.getString("time"),rs.getBigDecimal("price"));
                competitions.add(competition);
            }
            return competitions;
        } catch (SQLException e) {
            e.printStackTrace();
            return competitions;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,rs);
        }
    }

    /**
     * 添加赛事信息
     * @param competitionTxt
     * @return
     */
    @Override
    public Boolean competitionAdd(Competition competitionTxt) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "insert into `competition`(homeField,visitingField,introduction,time,price) values(?,?,?,?,?)";
        try{
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,competitionTxt.getHomeField());
            pstmt.setString(2,competitionTxt.getVisitingField());
            pstmt.setString(3,competitionTxt.getIntroduction());
            pstmt.setString(4,competitionTxt.getTime());
            pstmt.setBigDecimal(5,competitionTxt.getPrice());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,null);
        }
    }

    /**
     * 更改赛事信息
     * @param competitionTxt
     * @return
     */
    @Override
    public Competition competitionUpdate(Competition competitionTxt) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "update `competition` set homeField = ?,visitingField = ?,introduction = ?,time = ?,price = ? where id = ?";
        try{
            con = DatabaseConnectionUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,competitionTxt.getHomeField());
            pstmt.setString(2,competitionTxt.getVisitingField());
            pstmt.setString(3,competitionTxt.getIntroduction());
            pstmt.setString(4,competitionTxt.getTime());
            pstmt.setBigDecimal(5,competitionTxt.getPrice());
            pstmt.setInt(6,competitionTxt.getId());
            pstmt.executeUpdate();
            return competitionTxt;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            DatabaseConnectionUtil.close(con,pstmt,null);
        }
    }

    /**
     * 删除赛事信息
     * @param competitionId
     * @return
     */
    @Override
    public Boolean competitionDelete(Integer competitionId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        //删除该赛事的订单信息
        String sql1 = "delete from `order` where competitionID = ?";
        //删除赛事信息
        String sql2 = "delete from `competition` where id = ?";
        try {
            con = DatabaseConnectionUtil.getConnection();
            con.setAutoCommit(false);
            //删除该赛事的订单信息
            pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1,competitionId);
            pstmt.executeUpdate();
            //删除赛事信息
            pstmt = con.prepareStatement(sql2);
            pstmt.setInt(1,competitionId);
            pstmt.executeUpdate();
            con.commit();
            return true;
        }catch (SQLException e){
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
}
