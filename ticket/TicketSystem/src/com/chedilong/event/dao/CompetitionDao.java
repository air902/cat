package com.chedilong.event.dao;

import com.chedilong.event.entity.Competition;

import java.sql.Connection;
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

    /**
     * 添加赛事信息
     * @param competitionTxt
     * @return
     */
    Boolean competitionAdd(Competition competitionTxt);

    /**
     * 更改赛事信息
     * @param competitionTxt
     * @return
     */
    Competition competitionUpdate(Competition competitionTxt);

    /**
     * 删除赛事信息
     * @param competitionId
     * @return
     */
    Boolean competitionDelete(Integer competitionId);
}
