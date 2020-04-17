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
     * 查询比赛信息
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
}
