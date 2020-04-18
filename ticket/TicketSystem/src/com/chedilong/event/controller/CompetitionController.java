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

    /**
     * 添加赛事信息
     * @param competitionTxt
     * @return
     */
    public Boolean competitionAdd(Competition competitionTxt){
        CompetitionService competitionService = new CompetitionServiceImpl();
        Boolean result = competitionService.competitionAdd(competitionTxt);
        return  result;
    }

    /**
     * 更新赛事信息
     * @param competitionTxt
     * @return
     */
    public Competition competitionUpdate(Competition competitionTxt){
        CompetitionService competitionService = new CompetitionServiceImpl();
        Competition result = competitionService.competitionUpdate(competitionTxt);
        return result;
    }

    /**
     * 删除赛事信息
     * @param competitionId
     * @return
     */
    public Boolean competitionDelete(Integer competitionId){
        CompetitionService competitionService = new CompetitionServiceImpl();
        Boolean result = competitionService.competitionDelete(competitionId);
        return result;
    }
}
