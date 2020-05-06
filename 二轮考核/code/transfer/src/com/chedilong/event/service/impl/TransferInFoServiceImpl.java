package com.chedilong.event.service.impl;

import com.chedilong.event.dao.TransferInFoDao;
import com.chedilong.event.dao.impl.TransferInFoDaoImpl;
import com.chedilong.event.entity.TransferInFo;
import com.chedilong.event.service.TransferInFoService;
import com.chedilong.event.util.StringJudgeUtil;
import com.sun.org.apache.xerces.internal.impl.XMLEntityScanner;

import javax.imageio.spi.ImageInputStreamSpi;
import java.util.ArrayList;
import java.util.List;

public class TransferInFoServiceImpl implements TransferInFoService {

    /**
     * 获取符合要求的转会信息的总记录数和总页数
     * @param count 每页显示条数
     * @return
     */
    @Override
    public int[] totalPage(int count,String classify,String playerName) {
        //总记录数，总页数初始值分别为0和1
        int[] total = {0,1};
        TransferInFoDao transferInFoDao = new TransferInFoDaoImpl();
        List<Object> message = new ArrayList<>();
        String sql = null;
        //当用户选择搜索类型为全部时，对转会信息分类不作限制
        if(classify.equals("全部") && StringJudgeUtil.isEmpty(playerName)){
             sql  ="select * from  transferinfo";
        }else if(!classify.equals("全部") && StringJudgeUtil.isEmpty(playerName)){
             sql  ="select * from  transferinfo where classify = ?";
             message.add(classify);
        }else if(classify.equals("全部") && StringJudgeUtil.isNotEmpty(playerName)){
            sql  ="select * from  transferinfo where playerName like ?";
            playerName = "%"+playerName+"%";
            message.add(playerName);
        }else if(!classify.equals("全部") && StringJudgeUtil.isNotEmpty(playerName)){
            sql  ="select * from  transferinfo where classify = ? and playerName like ?";
            playerName = "%"+playerName+"%";
            message.add(classify);
            message.add(playerName);
        }
        List<TransferInFo> transferInFoList = transferInFoDao.transferInFoFind(sql,message);
        //获取总记录数
        total[0] = transferInFoList.size();
        //计算页数
        if(total[1]%count == 0){
            total[1] = total[0]/count;
        }else{
            total[1] = total[0]/count+1;
        }
        return total;
    }

    /**
     * 获取指定页数的转会信息
     * @param currentPage 当前页
     * @param count 每页显示信息条数
     * @param classify 类型
     * @param playerName 玩家姓名
     * @return
     */
    @Override
    public List<TransferInFo> transferInFoFind(int currentPage, int count,String classify,String playerName) {
        List<Object> message = new ArrayList<>();
        String sql = null;
        //当用户选择搜索类型为 全部 时，对转会信息分类不作限制
        if(classify.equals("全部")&& StringJudgeUtil.isEmpty(playerName)){
            sql  ="select * from transferinfo limit ?,?";
        }else if(!classify.equals("全部")&& StringJudgeUtil.isEmpty(playerName)){
            sql  ="select * from  transferinfo where classify = ? limit ?,?";
            message.add(classify);
        }else if(classify.equals("全部")&& StringJudgeUtil.isNotEmpty(playerName)){
            sql  ="select * from  transferinfo where playerName like ? limit ?,?";
            playerName = "%"+playerName+"%";
            message.add(playerName);
        }else if(!classify.equals("全部")&& StringJudgeUtil.isNotEmpty(playerName)){
            sql  ="select * from  transferinfo where classify = ? and playerName like ? limit ?,?";
            playerName = "%"+playerName+"%";
            message.add(classify);
            message.add(playerName);
        }
        message.add((currentPage-1)*count);
        message.add(count);
        List<TransferInFo> transferInFoList = new ArrayList<>();
        TransferInFoDao transferInFoDao = new TransferInFoDaoImpl();
        transferInFoList = transferInFoDao.transferInFoFind(sql,message);
        return transferInFoList;
    }

    /**
     * 通过玩家的转会信息
     *
     * @param playerId
     * @return
     */
    @Override
    public int transferPass(int playerId) {
        TransferInFoDao transferInFoDao = new TransferInFoDaoImpl();
        int result = transferInFoDao.transferPass(playerId);
        return result;
    }

    /**
     * 驳回和撤销选手的转会申请
     *
     * @param playerId
     * @return
     */
    @Override
    public int transferBan(int playerId) {
        TransferInFoDao transferInFoDao = new TransferInFoDaoImpl();
        String sql = "update transferinfo set status = '审核不通过' where playerId = ?";
        List<Object> message = new ArrayList<>();
        message.add(playerId);
        int result = transferInFoDao.transferInFoCud(sql,message);
        return result;
    }
}
