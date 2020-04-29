package com.chedilong.event.util;

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

    /**
     * 判断输入金额是否符合格式
     * @param str
     * @return
     */
    public static boolean isMoney(String str){
        //匹配充值金额输入值为1-9999.99
        if(str.matches("[1-9]{1}\\d{0,3}")){
            return true;
        }else if(str.matches("[1-9]{1}\\d{0,3}[.]\\d{1,2}")){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 判断输入时间是否符合格式
     * @param str
     * @return
     */
    public static boolean isTime(String str){
        if(str.matches("20\\d{2}-(0?[1-9]|1[0-2])-((0[1-9])|((1|2)[0-9])|30|31)-(0[1-9]|1[0-9]|2[0-4]):([0-5][0-9])")){
            return true;
        }else{
            return false;
        }
    }
}
