package com.chedilong.event.util;


import javax.swing.*;

public class StringJudgeUtil {
    private void StringUtil() {
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        //str.trim()将字符串中前后的空格去掉
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串是否不是空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if (str == null && "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMoney(String str){
        //匹配充值金额输入值为1-9999.99
        if(str.matches("[1-9]{1}\\d{0,3}")){
            return true;
        }else if(str.matches("[1-9]{1}\\d{0,3}[.]\\d{1,2}")){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "请输入正确的金额，每次充值不少于1元，不超过9999.99元！");
            return false;
        }

    }
}
