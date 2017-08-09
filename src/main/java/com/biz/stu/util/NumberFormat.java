package com.biz.stu.util;

import java.text.DecimalFormat;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 1:05 2017/8/9
 */
public class NumberFormat {
    public static float floatFormat(float value, int bits) {
        String pattern = "";
        for (int i = 0; i < bits; i++) {
            pattern += "#";
        }
        pattern += ".0";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formatValue = decimalFormat.format(value);
        return Float.valueOf(formatValue);
    }


}
