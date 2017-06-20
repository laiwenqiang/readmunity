package com.readmunity.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Henry on 17/6/21.
 */
public class DateUtil {
    /**
     * 当数据库存储的时候，很有可能将毫秒省略，如果需要对比时间，则无法获取相同的数值。此方法专门解决此问题。
     * 目的是将毫秒设置为空。
     * @param date
     * @return
     */
    public static Date millisecondSetZero(Date date){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }
}
