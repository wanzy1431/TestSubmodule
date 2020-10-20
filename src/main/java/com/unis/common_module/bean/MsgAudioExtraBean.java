package com.unis.common_module.bean;

//音频消息体
public class MsgAudioExtraBean {
    private int size;//bit
    private int duration;//时长：秒

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
}
