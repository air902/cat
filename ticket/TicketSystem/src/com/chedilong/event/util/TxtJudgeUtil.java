package com.chedilong.event.util;

import com.chedilong.event.entity.User;

import javax.swing.*;

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
}
