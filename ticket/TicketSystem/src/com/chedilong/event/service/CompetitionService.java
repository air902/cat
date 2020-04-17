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
}
