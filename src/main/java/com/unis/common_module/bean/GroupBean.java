package com.unis.common_module.bean;

public class GroupBean {

    /**
     * id : 1000100000000306001
     * createTime : null
     * creator : null
     * updateTime : null
     * modificator : null
     * groupName : IM小学
     * pinyin : IMXIAOXUE
     * groupTypeCode : school
     * schoolId : 1000000000000587269
     * avatarFileId : null
     * sourceId : 1000000000000587269
     * memberCount : 10
     * qrCode : null
     * notice : null
     */

    private String id;
    private Object createTime;
    private Object creator;
    private Object updateTime;
    private Object modificator;
    private String groupName;
    private String pinyin;
    private String groupTypeCode;
    private String schoolId;
    private Object avatarFileId;
    private String sourceId;
    private int memberCount;
    private Object qrCode;
    private Object notice;
    private boolean isSelect = false;//选择群聊时使用
    private boolean isCheck = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getCreator() {
        return creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getModificator() {
        return modificator;
    }

    public void setModificator(Object modificator) {
        this.modificator = modificator;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getGroupTypeCode() {
        return groupTypeCode;
    }

    public void setGroupTypeCode(String groupTypeCode) {
        this.groupTypeCode = groupTypeCode;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public Object getAvatarFileId() {
        return avatarFileId;
    }

    public void setAvatarFileId(Object avatarFileId) {
        this.avatarFileId = avatarFileId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public Object getQrCode() {
        return qrCode;
    }

    public void setQrCode(Object qrCode) {
        this.qrCode = qrCode;
    }

    public Object getNotice() {
        return notice;
    }

    public void setNotice(Object notice) {
        this.notice = notice;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
