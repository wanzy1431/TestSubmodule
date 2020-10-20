package com.unis.common_module.config;

import android.os.Environment;

import java.io.File;

public class Constants {
    // 存储
    public static final String USERINFO = "userInfo";
    public static final String ACCOUNT = "account";
    public static final String PWD = "password";
    public static final String ROOM = "room";
    public static final String AUTO_LOGIN = "auto_login";
    public static final String LOGOUT = "logout";
    public static final String ICON_URL = "icon_url";

    public static final String CHAT_INFO = "chatInfo";

    public static final String M_HOME = "M_HOME";//教与学
    public static final String M_MSG = "M_MSG";//消息
    public static final String M_WORK = "M_WORK";//Dapp
    public static final String M_CLASSES = "M_CLASSES";//班级

    public static final String INTENT_FROM_CARD = "intent_from_card";//名片分享
    public static final String INTENT_FROM_QR = "intent_from_qr";//二维码分享
    public static final String INTENT_FROM_CHAT = "intent_from_chat";//分享聊天
    public static final String INTENT_FROM_FILE = "intent_from_file";//文件分享
    public static final String INTENT_FROM_FOLDER = "intent_from_folder";//文件夹分享
    public static final String INTENT_FROM_CALENDAR = "intent_from_calendar";//日程分享
    public static final String CALENDAR = "calendar"; //日程
    public static final String TEXT = "text"; //文字
    public static final String IMAGE = "image"; //图片
    public static final String VOICE = "voice"; //音频
    public static final String FILE = "file"; //文件
    public static final String VIDEO = "video"; //视频
    public static final String FACE = "face"; //表情


    public static final String USERID = "user_id";
    public static final String USERSCHOOLID = "user_school_id";

    public static final String RADIO = "RADIO"; //单选
    public static final String MULTI = "MULTI"; //多选
    public static String CHOOSE_TYPE = "MULTI"; //选择类型

    public static String SOURCE = "SOURCE"; //来源
    public static String UNBIND = "unBind"; //解绑
    public static String BIND = "Bind"; //绑定

    public static boolean IS_MANAGER = false; //是否是群管理员

    public static boolean IS_FIRST_SHOW = true; //是否第一次出现
    public static boolean IS_CLEAR_DATA = false; //清空用户信息

    public static String CHAT_MSG = "CHAT_MSG"; //消息
    public static String CHAT_IS_NOT_NOTICE = "CHAT_IS_NOT_NOTICE"; //消息是否免打扰

    public static final String EXIT_ID = "exitId"; //退出ID 0被踢 1正常

    public static final String GROUP_MEMBER = "GROUP_MEMBER"; //群组成员
    public static final String DELETE_GROUP_MEMBER = "DELETE_GROUP_MEMBER"; //删除群组成员

    public static final String TEACHING_TAKEPICK = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "com.unis.teacher"
            + File.separator + "pic";//教与学图片照相地址

    public static final String TEACHING_APK = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "com.unis.teacher"
            + File.separator + "apk";//应用地址
}
