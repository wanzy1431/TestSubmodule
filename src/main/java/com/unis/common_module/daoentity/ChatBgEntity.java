package com.unis.common_module.daoentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ChatBgEntity {
    @Id
    private String chatId;
    private String keyId;
    private String chatBg;

    @Generated(hash = 421608148)
    public ChatBgEntity(String chatId, String keyId, String chatBg) {
        this.chatId = chatId;
        this.keyId = keyId;
        this.chatBg = chatBg;
    }

    @Generated(hash = 501135820)
    public ChatBgEntity() {
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

    public String getChatBg() {
        return this.chatBg;
    }

    public void setChatBg(String chatBg) {
        this.chatBg = chatBg;
    }


}
