package com.unis.common_module.bean;

import java.io.Serializable;
import java.util.List;

public class CalendarBean implements Serializable {

    private String shareType;//分享类型 calendar 日程  text 文字 image 图片  voice 音频  file 文件  video 视频  card 名片 face 表情
    /**
     * appId : 应用id
     * appName : 应用名称
     * detailUrl : 详情地址
     * deadline : 截至日期
     * title : 标题
     * place : 地点
     * calendarId : 日程id
     * accept : 接受状态，0未处理，1接受， 2拒绝
     */

    private String appId;
    private String appName;
    private String detailUrl;
    private String deadline;
    private String title;
    private String place;
    private String calendarId;
    private String accept;
    private List<String> participants;//参与人Id

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }
}
