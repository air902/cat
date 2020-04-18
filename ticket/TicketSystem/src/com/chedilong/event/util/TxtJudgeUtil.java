package com.chedilong.event.util;

import com.chedilong.event.entity.Competition;
import com.chedilong.event.entity.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Map;

public class TxtJudgeUtil {
    private TxtJudgeUtil(){}

    /**
     *判断用户输入的个人信息是否符合要求
     * @param userTxt
     * @param userSelect
     * @return
     */
    public static Boolean userTxtJudge(User userTxt, User userSelect){
        if(userSelect != null){
            if (userTxt.getName().equals(userSelect.getName())&&userTxt.getPassword().equals(userSelect.getPassword())){
                JOptionPane.showMessageDialog(null, "您未修改任何信息！");
                return false;
            }
        }
        if(StringJudgeUtil.isEmpty(userTxt.getName())){
            JOptionPane.showMessageDialog(null, "用户名不能为空！");
            return false;
        }
        if(StringJudgeUtil.isEmpty(userTxt.getPassword())){
            JOptionPane.showMessageDialog(null, "密码不能为空！");
            return true;
        }
        return true;
    }

    /**
     * 判断用户输入的比赛信息是否符合要求
     * @param competitionTxt
     * @return
     */
    public static Boolean competitionTxtJudge(Map<String,String> competitionTxt, Competition competitionSelect){
        if(competitionSelect != null){
            if(competitionTxt.get("homeFieldTxt").equals(competitionSelect.getHomeField())&&
               competitionTxt.get("visitingFieldTxt").equals(competitionSelect.getVisitingField())&&
               competitionTxt.get("timeTxt").equals(competitionSelect.getTime())&&
               (competitionSelect.getPrice().compareTo(new BigDecimal(competitionTxt.get("priceTxt"))) == 0)&&
               competitionTxt.get("introductionTxt").equals(competitionSelect.getIntroduction())){
                JOptionPane.showMessageDialog(null, "您未修改任何信息");
                return false;
            }
        }
        if(StringJudgeUtil.isEmpty(competitionTxt.get("homeFieldTxt"))){
            JOptionPane.showMessageDialog(null, "主场战队不能为空");
            return false;
        }
        if(StringJudgeUtil.isEmpty(competitionTxt.get("visitingFieldTxt"))){
            JOptionPane.showMessageDialog(null, "客场战队不能为空");
            return false;
        }
        if(!StringJudgeUtil.isTime(competitionTxt.get("timeTxt"))){
            JOptionPane.showMessageDialog(null, "请输入正确的时间");
            return false;
        }
        if(!StringJudgeUtil.isMoney(competitionTxt.get("priceTxt"))){
            JOptionPane.showMessageDialog(null, "请输入正确的价格");
            return false;
        }
        if(StringJudgeUtil.isEmpty(competitionTxt.get("introductionTxt"))){
            JOptionPane.showMessageDialog(null, "赛事简介不能为空");
            return false;
        }
        return true;
    }
}
