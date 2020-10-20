package com.unis.common_module.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.ArrayList;


public class SelectSessionBean implements MultiItemEntity, Serializable {
    private String userId;
    private String conversationId;
    private int type = 0;//0单聊 1群聊
    private String userName;
    private String userPhoto;
    private String content;//搜索聊天记录用
    private long contentNum;
    private String chatType;//搜索聊天记录用 1单聊 2群聊
    private boolean isShow = false;
    private boolean isSelect = false;

    public static final int PERSON = 0;
    public static final int LINE = 1;
    public static final int GROUP = 2;
    public static final int HISTORY = 3;
    private int itemType;

    public SelectSessionBean(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getContentNum() {
        return contentNum;
    }

    public void setContentNum(long contentNum) {
        this.contentNum = contentNum;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    @Override
    public boolean equals(Object arg0) {
        SelectSessionBean p = (SelectSessionBean) arg0;
        return conversationId.equals(p.conversationId);
    }

    @Override
    public int hashCode() {
        String str = conversationId;
        return str.hashCode();
    }


}
