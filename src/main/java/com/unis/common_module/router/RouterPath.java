package com.unis.common_module.router;

public interface RouterPath {

    /**
     * 组名
     */
    String APP = "/app";//宿主 App 组件
    String MSG = "/msg";//msg 组件
    String LOGIN = "/login";//登录
    String CLOUDDISK = "/clouddisk";//云盘组件
    String WORKBENCH = "/workbench";//工作台
    String STUDENT = "/student";//学生
    String TEACHING = "/teaching";//学生
    String COMMON = "/common";//common

    /**
     * 服务
     */
    String SERVICE = "/service";

    String MSG_SERVICE_HELLOSERVICE = MSG + SERVICE + "HelloService";

    /**
     * msg 组件
     */
    String MSG_MSGFRAGMENT = MSG + "/MsgFragment";
    String MSG_PERSONALINFORMATIONACTIVITY = MSG + "/PersonalInformationActivity";
    String MSG_STATUSACTIVITY = MSG + "/StatusActivity";
    String MSG_EXCHANGEUSERACTIVITY = MSG + "/ExchangeUserActivity";
    String MSG_SETTINGACTIVITY = MSG + "/SettingActivity";
    String MSG_DONOTDISTURBMODEACTIVITY = MSG + "/DonotDisturbModeActivity";
    String MSG_COLLECTIONACTIVITY = MSG + "/CollectionActivity";
    String MSG_SELECTMYHAVEGROUPACTIVITY = MSG + "/SelectMyhaveGroupActivity";
    String MSG_UNISCHATACTIVITY = MSG + "/UnisChatActivity";
    String MSG_COMMONSELECTIONWIDGETACTIVITY = "/msg/CommonSelectionWidgetActivity";
    String MSG_RADIOCONTACTACTIVITY = "/msg/RadioContactActivity";
    String MSG_COMMONCOMMONSELECTSESSIONACTIVITY = "/msg/CommonSelectSessionActivity";
    String MSG_CALENDARSELECTACTIVITY = "/msg/CalendarSelectActivity";
    String MSG_PERSONQRCODEACTIVITY = "/msg/PersonQrCodeActivity";
    String MSG_COMMON_CAPTUREACTIVITY = "/common/CaptureActivity";
    String MSG_PCLOGINACTIVITY = "/msg/PcLoginActivity";
    String MSG_USERINFOACTIVITY = "/msg/UserInfoActivity";


    /**
     * login 组件
     */
    String LOGIN_LOGINACTIVITY = LOGIN + "/LoginActivity";
    String LOGIN_FORGETPASSWORDACTIVITY = LOGIN + "/ForgetPasswordActivity";

    /**
     * cloud disk 组件
     */
    public static final String CLOUDDISK_MINE = CLOUDDISK + "/MyCloudActivity2";
    public static final String CLOUDDISK_SELECT_FOLDER = CLOUDDISK + "/MoveFileFolderActivity";
    public static final String CLOUDDISK_GROUP_OR_CLASS = CLOUDDISK + "/RootFolderActivity";
    public static final String CLOUDDISK_RECENT_USE = CLOUDDISK + "/AllRecentUseActivity";
    public static final String CLOUDDISK_ROOT_PAGE = CLOUDDISK + "/CloudRootActivity";
    public static final String CLOUDDISK_RECENT = CLOUDDISK + "/RecentUseActivity";


    /**
     * App 组件
     */
    String APP_MAINACTIVITY = APP + "/MainActivity";

    /**
     * COMMON 组件
     */
    String APP_WEBACTIVITY = COMMON + "/WebViewActivity";

    /*
     * student组件
     * */
    String STUDENT_STUDENTACTIVITY = STUDENT + "/MainActivity";


    /**
     * 工作台组件
     */

    String WORKBENCH_WORKBENCHFRAGMENT = WORKBENCH + "/WorkbenchFragment";
    String WORKBENCH_WORKADD = WORKBENCH + "/WorkAddCommonActivity";

    /**
     * teaching 组件
     */
    String TEACHING_FRAGMENT = TEACHING + "/TeachingFragment";
}
