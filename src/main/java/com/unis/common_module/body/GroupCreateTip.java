package com.unis.common_module.body;

import java.util.List;

public class GroupCreateTip {

    /**
     * operatorId : 1000100000000527061
     * operatorName : 张3
     * members : [{"userId":1000100000000527001,"userName":"李4"},{"userId":1000100000000527002,"userName":"王5"}]
     * groupId : 1000100000001130001
     * groupName : 群名称
     * avatarUrl : 群头像
     * createTime : 创建群时间
     */

    private long operatorId;
    private String operatorName;
    private long groupId;
    private String groupName;
    private String avatarUrl;
    private String createTime;
    private List<MembersBean> members;
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<MembersBean> getMembers() {
        return members;
    }

    public void setMembers(List<MembersBean> members) {
        this.members = members;
    }

    public static class MembersBean {
        /**
         * userId : 1000100000000527001
         * userName : 李4
         */

        private long userId;
        private String userName;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
