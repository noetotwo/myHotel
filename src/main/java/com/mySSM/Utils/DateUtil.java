package com.mySSM.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    static long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
    static long nh = 1000 * 60 * 60;// 一小时的毫秒数
    static long nm = 1000*60;

    private static SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 得到现在的时间，并以yyyy-MM-dd hh:mm:ss的格式输出
     * @return 以yyyy-MM-dd hh:mm:ss的格式输出
     */
    public static String getNowDate(){
        String time = "";
        time = dateFormat.format(new Date());
        return time;
    }

    /**
     * 比较date与现在的时间差几分钟
     * @param date 比较的时间
     * @return 返回时间差
     */
    public static long isTimeOut(String date) {
        long second = 0;
        try {
            Date time = dateFormat.parse(date);
            long millisecond =(new Date()).getTime() - time.getTime();
            second = millisecond % nd % nh / nm;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return second;
    }

}
