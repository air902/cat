package com.chedilong.event.controller;

import com.chedilong.event.entity.Competition;
import com.chedilong.event.service.CompetitionService;
import com.chedilong.event.service.impl.CompetitionServiceImpl;

import java.util.List;

public class CompetitionController {
    /**
     * 获取用户搜索的比赛信息信息
     * @param teamName
     * @return
     */
    public List<Competition> competitionSearch(String teamName) {
        CompetitionService competitionService = new CompetitionServiceImpl();
        List<Competition> competitions = competitionService.competitionSearch(teamName);
        return competitions;
    }
}
