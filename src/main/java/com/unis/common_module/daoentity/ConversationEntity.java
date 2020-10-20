package com.unis.common_module.daoentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;


@Entity
public class ConversationEntity {
    @Id
    private String conversationId;
    private String keyId;
    private String toName;
    private int chatType;
    private String from;
    private String fromSchoolId;
    private String to;
    private String toSchoolId;
    private String msgId;
    private String content;
    private long createTime;
    private String msgType;
    private String chatBackground;
    private String delTime;
    private String clearTime;
    private int topped;
    private String lastReadMsgId;
    private String userPhoto;
    private String msgTime;
    private int unreadCount;
    private boolean isNotDisturb;
    private String lastMsgId;//最后上报的消息id

    private int isLoadAllUnReadCount; //1 全部加载完成 0 未全部加载完成
    private boolean isRemove;
    private boolean isExit;

    @Generated(hash = 2084590879)
    public ConversationEntity(String conversationId, String keyId, String toName, int chatType, String from,
                              String fromSchoolId, String to, String toSchoolId, String msgId, String content, long createTime,
                              String msgType, String chatBackground, String delTime, String clearTime, int topped, String lastReadMsgId,
                              String userPhoto, String msgTime, int unreadCount, boolean isNotDisturb, String lastMsgId,
                              int isLoadAllUnReadCount, boolean isRemove, boolean isExit) {
        this.conversationId = conversationId;
        this.keyId = keyId;
        this.toName = toName;
        this.chatType = chatType;
        this.from = from;
        this.fromSchoolId = fromSchoolId;
        this.to = to;
        this.toSchoolId = toSchoolId;
        this.msgId = msgId;
        this.content = content;
        this.createTime = createTime;
        this.msgType = msgType;
        this.chatBackground = chatBackground;
        this.delTime = delTime;
        this.clearTime = clearTime;
        this.topped = topped;
        this.lastReadMsgId = lastReadMsgId;
        this.userPhoto = userPhoto;
        this.msgTime = msgTime;
        this.unreadCount = unreadCount;
        this.isNotDisturb = isNotDisturb;
        this.lastMsgId = lastMsgId;
        this.isLoadAllUnReadCount = isLoadAllUnReadCount;
        this.isRemove = isRemove;
        this.isExit = isExit;
    }

    @Generated(hash = 2044044276)
    public ConversationEntity() {
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getToName() {
        return this.toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public int getChatType() {
        return this.chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromSchoolId() {
        return this.fromSchoolId;
    }

    public void setFromSchoolId(String fromSchoolId) {
        this.fromSchoolId = fromSchoolId;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToSchoolId() {
        return this.toSchoolId;
    }

    public void setToSchoolId(String toSchoolId) {
        this.toSchoolId = toSchoolId;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getChatBackground() {
        return this.chatBackground;
    }

    public void setChatBackground(String chatBackground) {
        this.chatBackground = chatBackground;
    }

    public String getDelTime() {
        return this.delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public String getClearTime() {
        return this.clearTime;
    }

    public void setClearTime(String clearTime) {
        this.clearTime = clearTime;
    }

    public int getTopped() {
        return this.topped;
    }

    public void setTopped(int topped) {
        this.topped = topped;
    }

    public String getLastReadMsgId() {
        return this.lastReadMsgId;
    }

    public void setLastReadMsgId(String lastReadMsgId) {
        this.lastReadMsgId = lastReadMsgId;
    }

    public String getUserPhoto() {
        return this.userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getMsgTime() {
        return this.msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public boolean getIsNotDisturb() {
        return this.isNotDisturb;
    }

    public void setIsNotDisturb(boolean isNotDisturb) {
        this.isNotDisturb = isNotDisturb;
    }

    public String getLastMsgId() {
        return this.lastMsgId;
    }

    public void setLastMsgId(String lastMsgId) {
        this.lastMsgId = lastMsgId;
    }

    public int getIsLoadAllUnReadCount() {
        return this.isLoadAllUnReadCount;
    }

    public void setIsLoadAllUnReadCount(int isLoadAllUnReadCount) {
        this.isLoadAllUnReadCount = isLoadAllUnReadCount;
    }

    public boolean getIsRemove() {
        return this.isRemove;
    }

    public void setIsRemove(boolean isRemove) {
        this.isRemove = isRemove;
    }

    public boolean getIsExit() {
        return this.isExit;
    }

    public void setIsExit(boolean isExit) {
        this.isExit = isExit;
    }

}
