package com.unis.common_module.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static long stingToLong(String date, String formatType) {
        if (TextUtils.isEmpty(date)) {
            return 01;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
        Date vDate = null;
        try {
            vDate = simpleDateFormat.parse(date);
            long time = vDate.getTime();
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public static long timeParse(long duration) {
        long minute = duration / 60000;
        return minute;
    }

}
