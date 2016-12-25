package com.learning.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * TimeUtil
 * Created by lw on 16-12-19.
 */
public class TimeUtil {
    /**
     * 获得当前时间
     */
    public static Date getDateNow() {
        Date date = new Date();
        return date;
    }

    /**
     * 获得当前时间
     */
    public static String getDate(String formatter) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        localDateTime.format(dateTimeFormatter);
        return localDateTime.toString();
    }

}
