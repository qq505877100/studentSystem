package com.biz.stu.converters;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 23:08 2017/8/6
 */
public class DateConverter implements Converter<String,Date> {
    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
