package vip.incolor.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/9
 * @time 19:10
 */
public class DateUtil {
    public static String getTimeStampInString(){
        Date nowInMs=new Date(System.currentTimeMillis());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowInMs);
        calendar.set(Calendar.MILLISECOND,0);
        Date nowInS=calendar.getTime();
        String timeStamp=String.valueOf(nowInS.getTime());
        return timeStamp.substring(0,10);
    }
}
