package com.unis.common_module.daoentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class GroupSetEntity {
    @Id
    private String chatId;
    private String keyId;
    private String settingKey;
    private String value;
    private int chatType;//2群聊 1单聊
    private boolean isNotDisturb;

    @Generated(hash = 646229014)
    public GroupSetEntity(String chatId, String keyId, String settingKey,
                          String value, int chatType, boolean isNotDisturb) {
        this.chatId = chatId;
        this.keyId = keyId;
        this.settingKey = settingKey;
        this.value = value;
        this.chatType = chatType;
        this.isNotDisturb = isNotDisturb;
    }

    @Generated(hash = 835059323)
    public GroupSetEntity() {
    }

    public String getChatId() {
        return this.chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getSettingKey() {
        return this.settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getChatType() {
        return this.chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }

    public boolean getIsNotDisturb() {
        return this.isNotDisturb;
    }

    public void setIsNotDisturb(boolean isNotDisturb) {
        this.isNotDisturb = isNotDisturb;
    }


}
