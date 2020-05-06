package com.chedilong.event.service;

import com.chedilong.event.entity.TransferInFo;

import java.util.List;

/**
 * 转会信息相关操作
 */
public interface TransferInFoService {
    /**
     * 获取符合要求的转会信息总记录数和总页数
     * @param count
     * @param classify
     * @param playerName
     * @return
     */
    int[] totalPage(int count,String classify,String playerName);

    /**
     * 获取指定页数的转会信息
     * @param currentPage 当前页
     * @param count 每页显示信息条数
     * @param classify 类型
     * @param playerName 玩家姓名
     * @return
     */
    List<TransferInFo> transferInFoFind(int currentPage, int count,String classify,String playerName);

    /**
     * 通过玩家的转会信息
     * @param playerId
     * @return
     */
    int transferPass(int playerId);

    /**
     * 驳回和撤销选手的转会申请
     * @param playerId
     * @return
     */
    int transferBan(int playerId);
}
