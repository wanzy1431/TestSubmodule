package com.unis.common_module.daoentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class OrganizeEntity {
    @Id
    private String id;
    private String keyId;
    private String createTime;
    private String creator;
    private String updateTime;
    private String modificator;
    private String label;
    private String parentId;
    private int orderno;
    private boolean checked;
    private boolean isEnable = true;
    private String nodeType;
    private String userPhoto;
    private boolean isSelect;
    private String userId;
    private String noRepeatId;


    @Generated(hash = 525661994)
    public OrganizeEntity(String id, String keyId, String createTime, String creator, String updateTime,
            String modificator, String label, String parentId, int orderno, boolean checked, boolean isEnable,
            String nodeType, String userPhoto, boolean isSelect, String userId, String noRepeatId) {
        this.id = id;
        this.keyId = keyId;
        this.createTime = createTime;
        this.creator = creator;
        this.updateTime = updateTime;
        this.modificator = modificator;
        this.label = label;
        this.parentId = parentId;
        this.orderno = orderno;
        this.checked = checked;
        this.isEnable = isEnable;
        this.nodeType = nodeType;
        this.userPhoto = userPhoto;
        this.isSelect = isSelect;
        this.userId = userId;
        this.noRepeatId = noRepeatId;
    }


    @Generated(hash = 414560711)
    public OrganizeEntity() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizeEntity that = (OrganizeEntity) o;
        return id.equals(that.id);
    }


    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getKeyId() {
        return this.keyId;
    }


    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }


    public String getCreateTime() {
        return this.createTime;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getCreator() {
        return this.creator;
    }


    public void setCreator(String creator) {
        this.creator = creator;
    }


    public String getUpdateTime() {
        return this.updateTime;
    }


    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    public String getModificator() {
        return this.modificator;
    }


    public void setModificator(String modificator) {
        this.modificator = modificator;
    }


    public String getLabel() {
        return this.label;
    }


    public void setLabel(String label) {
        this.label = label;
    }


    public String getParentId() {
        return this.parentId;
    }


    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public int getOrderno() {
        return this.orderno;
    }


    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }


    public boolean getChecked() {
        return this.checked;
    }


    public void setChecked(boolean checked) {
        this.checked = checked;
    }


    public String getNodeType() {
        return this.nodeType;
    }


    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }


    public String getUserPhoto() {
        return this.userPhoto;
    }


    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }


    public boolean getIsSelect() {
        return this.isSelect;
    }


    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }


    public String getUserId() {
        return this.userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getNoRepeatId() {
        return this.noRepeatId;
    }


    public void setNoRepeatId(String noRepeatId) {
        this.noRepeatId = noRepeatId;
    }


    public boolean getIsEnable() {
        return this.isEnable;
    }


    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }


}
