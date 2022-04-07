package com.mySSM.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 得到现在的时间，并以yyyy-MM-dd hh:mm:ss的格式输出
     * @return 以yyyy-MM-dd hh:mm:ss的格式输出
     */
    public static String getNowDate(){
        String time = "";
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        time = dateFormat.format(new Date());
        return time;
    }
}
