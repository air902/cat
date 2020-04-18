package com.chedilong.event.service;

import com.chedilong.event.entity.Competition;

import java.util.List;

public interface CompetitionService {
    /**
     * 根据输入的搜索信息获取比赛信息
     * @param teamName
     * @return
     */
    List<Competition> competitionSearch(String teamName);

    /**
     * 添加赛事信息
     * @param competitionTxt
     * @return
     */
    Boolean competitionAdd(Competition competitionTxt);

    /**
     * 更新赛事信息
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
