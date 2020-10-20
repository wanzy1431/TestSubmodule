package com.unis.common_module.bean;

import java.util.List;

public class SchoolOrganizeListBean {

    /**
     * id : 1000000000003005008
     * createTime : null
     * creator : null
     * updateTime : null
     * modificator : null
     * label : 教师
     * parentId : 100000000
     * orderno : 249
     * children : null
     * extra : {"userPhoto":null,"checked":false,"nodeType":"teacher","userId":"1000000000003005007"}
     */

    private String id;
    private String createTime;
    private String creator;
    private String updateTime;
    private String modificator;
    private String label;
    private String parentId;
    private int orderno;
    private ExtraBean extra;
    private String noRepeatId;
    private List<SchoolOrganizeListBean> children;

    public String getId() {
        return id;
    }

    public String getNoRepeatId() {
        return noRepeatId;
    }

    public void setNoRepeatId(String noRepeatId) {
        this.noRepeatId = noRepeatId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getModificator() {
        return modificator;
    }

    public void setModificator(String modificator) {
        this.modificator = modificator;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public List<SchoolOrganizeListBean> getChildren() {
        return children;
    }

    public void setChildren(List<SchoolOrganizeListBean> children) {
        this.children = children;
    }

    public ExtraBean getExtra() {
        return extra;
    }

    public void setExtra(ExtraBean extra) {
        this.extra = extra;
    }

    public static class ExtraBean {
        /**
         * userPhoto : null
         * checked : false
         * nodeType : teacher
         * userId : 1000000000003005007
         */

        private String userPhoto;
        private boolean checked;
        private String nodeType;
        private String userId;

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String getNodeType() {
            return nodeType;
        }

        public void setNodeType(String nodeType) {
            this.nodeType = nodeType;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
