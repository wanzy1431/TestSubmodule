package com.unis.common_module.daoentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class GroupEntity {
    @Id
    private String conversationId;
    private String keyId;
    private String groupName;
    private String pinyin;
    private String groupPhoto;

    @Generated(hash = 115711019)
    public GroupEntity(String conversationId, String keyId, String groupName,
                       String pinyin, String groupPhoto) {
        this.conversationId = conversationId;
        this.keyId = keyId;
        this.groupName = groupName;
        this.pinyin = pinyin;
        this.groupPhoto = groupPhoto;
    }

    @Generated(hash = 954040478)
    public GroupEntity() {
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

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getGroupPhoto() {
        return this.groupPhoto;
    }

    public void setGroupPhoto(String groupPhoto) {
        this.groupPhoto = groupPhoto;
    }


}
