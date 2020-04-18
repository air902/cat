package com.chedilong.event.service.impl;

import com.chedilong.event.dao.CompetitionDao;
import com.chedilong.event.dao.impl.CompetitionDaoImpl;
import com.chedilong.event.entity.Competition;
import com.chedilong.event.service.CompetitionService;

import java.util.List;

public class CompetitionServiceImpl implements CompetitionService {
    /**
     * 根据输入的搜索信息获取比赛信息
     * @param teamName
     * @return
     */
    @Override
    public List<Competition> competitionSearch(String teamName) {
        CompetitionDao competitionDAo = new CompetitionDaoImpl();
        List<Competition> competitions = competitionDAo.competitionSearch(teamName);
        return competitions;
    }

    /**
     * 添加赛事信息
     * @param competitionTxt
     * @return
     */
    @Override
    public Boolean competitionAdd(Competition competitionTxt) {
        CompetitionDao competitionDao = new CompetitionDaoImpl();
        Boolean result = competitionDao.competitionAdd(competitionTxt);
        return result;
    }

    /**
     * 更新赛事信息
     * @param competitionTxt
     * @return
     */
    @Override
    public Competition competitionUpdate(Competition competitionTxt) {
        CompetitionDao competitionDao = new CompetitionDaoImpl();
        Competition result = competitionDao.competitionUpdate(competitionTxt);
        return result;
    }

    /**
     * 删除赛事信息
     *
     * @param competitionId
     * @return
     */
    @Override
    public Boolean competitionDelete(Integer competitionId) {
        CompetitionDao competitionDao = new CompetitionDaoImpl();
        Boolean result = competitionDao.competitionDelete(competitionId);
        return result;
    }
}
