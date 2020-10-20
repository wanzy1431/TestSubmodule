package com.unis.common_module.bean;

import java.util.Objects;

public class ReadContentBean {

    /**
     * msgId : 0df483c35343452d8fc17e07ff7fe9ea
     * readCount : 1
     * memberCount : 0
     */

    private String msgId;
    private int readCount;
    private int memberCount;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReadContentBean)) return false;
        ReadContentBean that = (ReadContentBean) o;
        return msgId.equals(that.msgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgId);
    }
}
