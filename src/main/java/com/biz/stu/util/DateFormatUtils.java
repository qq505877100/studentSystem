package com.biz.stu.util;


import org.junit.Test;
import org.springframework.cglib.core.Local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 17:42 2017/8/7
 */
public class DateFormatUtils {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    public static Date stringToDate(String str) {
        try {
            new Date();
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }




}


