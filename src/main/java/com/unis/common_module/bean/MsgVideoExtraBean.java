package com.unis.common_module.bean;

//视频消息体
public class MsgVideoExtraBean {
    private int size;//bit
    private int duration;//时长：秒
    private String thumbUrl; //缩略图地址

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
}
