package com.unis.common_module.daoentity;

import com.google.gson.Gson;
import com.unis.common_module.bean.ReferenceBean;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.converter.PropertyConverter;

@Entity
public class ImTextBeanEntity {
    @Id
    private String msgId;//消息id
    private String keyId;
    private String from;
    private String fromSchoolId;
    private String to;
    private String toSchoolId;
    @Index
    private long createTime;
    private String msgType;
    @Index
    private String conversationId;
    private String chatType;
    private String userId;
    private String toName;
    private String fromName;
    private String userPhoto;
    private String content;
    private String nameCard; // 发送者的群名片
    private String friendRemark; //好友备注
    private String nickName; // 昵称

    private String faceUrl;
    private String newMsgId; // 撤回消息的系统Id


    //文件需要的字段
    private String fileName;
    private long fileSize;

    //表情字段
    private int faceIndex;

    //已读 未读
    private String isAllRead;
    private String readCount;
    private int isMineRead; //1 自己已读 0 自己未读


    //图片相关
    private String UUID;

    private int status;

    private int elemType;

    private long msgTime;
    private String cmd;
    //音视频相关 扩展字段
    private int size;
    private int duration;
    private String operatorId;
    private String extra;

    @Convert(columnType = String.class, converter = ReferenceConverter.class)
    private ReferenceBean referenceBean;

    @Generated(hash = 1714380169)
    public ImTextBeanEntity(String msgId, String keyId, String from, String fromSchoolId, String to,
                            String toSchoolId, long createTime, String msgType, String conversationId, String chatType,
                            String userId, String toName, String fromName, String userPhoto, String content,
                            String nameCard, String friendRemark, String nickName, String faceUrl, String newMsgId,
                            String fileName, long fileSize, int faceIndex, String isAllRead, String readCount,
                            int isMineRead, String UUID, int status, int elemType, long msgTime, String cmd, int size,
                            int duration, String operatorId, String extra, ReferenceBean referenceBean) {
        this.msgId = msgId;
        this.keyId = keyId;
        this.from = from;
        this.fromSchoolId = fromSchoolId;
        this.to = to;
        this.toSchoolId = toSchoolId;
        this.createTime = createTime;
        this.msgType = msgType;
        this.conversationId = conversationId;
        this.chatType = chatType;
        this.userId = userId;
        this.toName = toName;
        this.fromName = fromName;
        this.userPhoto = userPhoto;
        this.content = content;
        this.nameCard = nameCard;
        this.friendRemark = friendRemark;
        this.nickName = nickName;
        this.faceUrl = faceUrl;
        this.newMsgId = newMsgId;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.faceIndex = faceIndex;
        this.isAllRead = isAllRead;
        this.readCount = readCount;
        this.isMineRead = isMineRead;
        this.UUID = UUID;
        this.status = status;
        this.elemType = elemType;
        this.msgTime = msgTime;
        this.cmd = cmd;
        this.size = size;
        this.duration = duration;
        this.operatorId = operatorId;
        this.extra = extra;
        this.referenceBean = referenceBean;
    }

    @Generated(hash = 1065803406)
    public ImTextBeanEntity() {
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
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

    public String getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getChatType() {
        return this.chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToName() {
        return this.toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getFromName() {
        return this.fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getUserPhoto() {
        return this.userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameCard() {
        return this.nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getFriendRemark() {
        return this.friendRemark;
    }

    public void setFriendRemark(String friendRemark) {
        this.friendRemark = friendRemark;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getNewMsgId() {
        return this.newMsgId;
    }

    public void setNewMsgId(String newMsgId) {
        this.newMsgId = newMsgId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getFaceIndex() {
        return this.faceIndex;
    }

    public void setFaceIndex(int faceIndex) {
        this.faceIndex = faceIndex;
    }

    public String getIsAllRead() {
        return this.isAllRead;
    }

    public void setIsAllRead(String isAllRead) {
        this.isAllRead = isAllRead;
    }

    public String getReadCount() {
        return this.readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public int getIsMineRead() {
        return this.isMineRead;
    }

    public void setIsMineRead(int isMineRead) {
        this.isMineRead = isMineRead;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getElemType() {
        return this.elemType;
    }

    public void setElemType(int elemType) {
        this.elemType = elemType;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public void setMsgTime(long msgTime) {
        this.msgTime = msgTime;
    }

    public String getCmd() {
        return this.cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public ReferenceBean getReferenceBean() {
        return this.referenceBean;
    }

    public void setReferenceBean(ReferenceBean referenceBean) {
        this.referenceBean = referenceBean;
    }

    public static class ReferenceConverter implements PropertyConverter<ReferenceBean, String> {
        @Override
        public ReferenceBean convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            return new Gson().fromJson(databaseValue, ReferenceBean.class);
        }

        @Override
        public String convertToDatabaseValue(ReferenceBean entityProperty) {
            if (entityProperty == null) {
                return null;
            }
            return new Gson().toJson(entityProperty);
        }
    }


}
