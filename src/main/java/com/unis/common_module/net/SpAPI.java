package com.unis.common_module.net;

import com.unis.common_module.R;
import com.unis.common_module.utils.AppContextUtil;
import com.unis.common_module.utils.SpUtils;

import java.util.HashSet;
import java.util.Set;

public enum SpAPI {
    THIS;

    public static String F_MOXINIP = "f_Moxin";//file name
    //存储账号
//    int ID_account = R.string.acount_key;
    int ID_account = R.string.app_name;
    int ID_password = R.string.password_key;
    int ID_token = R.string.token_key;
    int ID_notice_time = R.string.notice_time_key;
    int ID_notice_start_time = R.string.notice_start_time_key;
    int ID_user_id = R.string.user_id_key;
    int ID_user_sign = R.string.user_sign_key;
    int ID_school_id = R.string.school_id_key;
    int ID_db_id = R.string.db_id_key;
    int ID_is_first_login = R.string.is_first_login_key;
    int ID_is_need_refresh = R.string.is_need_refresh_key;
    int ID_receive_notice = R.string.receive_notice;
    int ID_time_notice = R.string.receive_notice;
    int ID_receive_sound = R.string.receive_sound;
    int ID_show_notice = R.string.show_notice;
    int ID_account_type = R.string.account_type;
    int ID_user_photo = R.string.user_photo;


    //    public void setAccount(String account){
//        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(),AppContextUtil.getContext().getString(ID_account),account);
//    }
//    public String getAccount(){
//       return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_account), "");
//    }
    //存储密码
    public void setPassWord(String passWord) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_password), passWord);
    }

    //获取密码
    public String getPassword() {
        return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_password), "");
    }

    public void setAccount(Set<String> accounts) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_account), accounts);
    }

    public Set<String> getAccounts() {
        return (HashSet<String>) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_account), new HashSet<>());
    }

    //存储当前token
    public void setToken(String token) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_token), token);
    }

    public String getToken() {
        return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_token), "");
    }

    //存储勿扰时间
    public void setNoticeTime(int timeMinutes) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_notice_time), timeMinutes);
    }

    public int getNoticeTime() {
        return (int) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_notice_time), 0);
    }

    public void setNoticeStartTime(long startTime) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_notice_start_time), startTime);
    }

    public long getNoticeStartTime() {
        return (long) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_notice_start_time), 0l);
    }

    //存储账号类型
    public void setAccountType(String accountType) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_account_type), accountType);
    }

    public String getAccountType() {
        return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_account_type), "");
    }

    //存储账号
    public void setUserId(String userId) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_user_id), userId);
    }

    public String getUserId() {
        return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_user_id), "");
    }
    //存储userSign
    public void setUserSign(String userSign) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_user_sign), userSign);
    }

    public String getUserSign() {
        return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_user_sign), "");
    }

    //存储账号头像
    public void setUserPhoto(String userPhoto) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_user_photo), userPhoto);
    }

    public String getUserPhoto() {
        return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_user_photo), "");
    }


    public void setSchoolId(String schoolId) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_school_id), schoolId);
    }

    public String getSchoolId() {
        return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_school_id), "");
    }

    public void setDbKey(String userKeyId) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_db_id), userKeyId);
    }

    public String getDbKey() {
        return (String) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_db_id), "");
    }

    //是否是首次登录
    public void setIsFirstLogin(boolean isFirst) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_is_first_login), isFirst);
    }

    public boolean getIsFirstLogin() {
        return (boolean) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_is_first_login), false);
    }

    //是否需要从服务器获取会话列表
    public void setIsNeedRefresh(boolean isNeedRefresh) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_is_need_refresh), isNeedRefresh);
    }

    public boolean getIsNeedRefresh() {
        return (boolean) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_is_need_refresh), false);
    }

    //勿扰模式
    public void setTimeDisturb(boolean isReceive) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_time_notice), isReceive);
    }

    public boolean getTimeDisturb() {
        return (boolean) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_time_notice), false);
    }

    //是否接收新消息通知
    public void setReceiveNotice(boolean isReceive) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_receive_notice), isReceive);
    }

    public boolean getReceiveNotice() {
        return (boolean) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_receive_notice), true);
    }

    //是否接收语音和视频消息通知
    public void setReceiveSound(boolean isReceive) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_receive_sound), isReceive);
    }

    public boolean getReceiveSound() {
        return (boolean) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_receive_sound), false);
    }

    //是否显示消息详情
    public void setShowNotice(boolean isShow) {
        SpUtils.setParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_show_notice), isShow);
    }

    public boolean getShowNotice() {
        return (boolean) SpUtils.getParam(F_MOXINIP, AppContextUtil.getContext(), AppContextUtil.getContext().getString(ID_show_notice), false);
    }


}

