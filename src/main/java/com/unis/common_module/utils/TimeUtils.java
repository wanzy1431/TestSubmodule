package com.unis.common_module.utils;

import android.content.Context;

import com.unis.common_module.R;
import com.unis.common_module.net.SpAPI;

//import com.unis.teacher.R;
//import com.unis.teacher.net.SpAPI;

public class TimeUtils {

    public static String getFormatTime(Context context) {
        int minutes = getRegTime();
        StringBuilder time = new StringBuilder();
        if (minutes >= 60) {
            int hour = minutes / 60;
            time.append(hour).append(context.getString(R.string.hour));
            int minute = minutes % 60;
            if (minute > 0) {
                time.append(minute).append(context.getString(R.string.minute));
            }

        } else {
            time = time.append(minutes).append(context.getString(R.string.minute));
        }
        return time.toString();
    }

    //获取倒计时剩余分钟
    public static int getRegTime() {
        long totalSecond = (System.currentTimeMillis() - SpAPI.THIS.getNoticeStartTime()) / 1000;
        long duratinMin = totalSecond / 60;
        int noticeTime = SpAPI.THIS.getNoticeTime();
        int regTime = (int) (noticeTime - duratinMin);
        return regTime;
    }
}

