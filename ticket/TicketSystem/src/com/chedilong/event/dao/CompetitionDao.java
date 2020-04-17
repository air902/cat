package com.chedilong.event.dao;

import com.chedilong.event.entity.Competition;

import java.util.List;

public interface CompetitionDao {
    /**
     * 关键词查询比赛信息
     * @param teamName
     * @return
     */
    List<Competition> competitionSearch(String teamName);

    /**
     * 用户查询个人预约比赛
     * @param competitionIDList
     * @return
     */
    List<Competition> competitionSearch(List<Integer> competitionIDList);
}
