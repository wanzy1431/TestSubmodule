package com.unis.common_module.bean;

public class NoticeSearchBean {

    /**
     * id : 1000100000000690402
     * createTime : 2020-07-28 14:58:42
     * creator : 1000000000003138015
     * updateTime : 2020-07-28 14:58:42
     * modificator : 1000000000003138015
     * groupId : 1000100000000690225
     * noticeContent : bbbbbnn
     * topped : 0
     * readCount : 0
     * unreadCount : null
     * readUsers : null
     * unreadUsers : null
     * operator : {"userId":"1000000000003138015","createTime":"2020-07-07 16:03:06","groupCount":37,"friendCount":null,"userSign":null,"channelType":null,"userName":"IM教师5"}
     */

    private String id;
    private String createTime;
    private String creator;
    private String updateTime;
    private String modificator;
    private String groupId;
    private String noticeContent;
    private int topped;
    private int readCount;
    private String unreadCount;
    private String readUsers;
    private String unreadUsers;
    private OperatorBean operator;

    public String getId() {
        return id;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public int getTopped() {
        return topped;
    }

    public void setTopped(int topped) {
        this.topped = topped;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(String unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getReadUsers() {
        return readUsers;
    }

    public void setReadUsers(String readUsers) {
        this.readUsers = readUsers;
    }

    public String getUnreadUsers() {
        return unreadUsers;
    }

    public void setUnreadUsers(String unreadUsers) {
        this.unreadUsers = unreadUsers;
    }

    public OperatorBean getOperator() {
        return operator;
    }

    public void setOperator(OperatorBean operator) {
        this.operator = operator;
    }

    public static class OperatorBean {
        /**
         * userId : 1000000000003138015
         * createTime : 2020-07-07 16:03:06
         * groupCount : 37
         * friendCount : null
         * userSign : null
         * channelType : null
         * userName : IM教师5
         */

        private String userId;
        private String createTime;
        private int groupCount;
        private String friendCount;
        private String userSign;
        private String channelType;
        private String userName;
        private String userPhoto;

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getGroupCount() {
            return groupCount;
        }

        public void setGroupCount(int groupCount) {
            this.groupCount = groupCount;
        }

        public String getFriendCount() {
            return friendCount;
        }

        public void setFriendCount(String friendCount) {
            this.friendCount = friendCount;
        }

        public String getUserSign() {
            return userSign;
        }

        public void setUserSign(String userSign) {
            this.userSign = userSign;
        }

        public String getChannelType() {
            return channelType;
        }

        public void setChannelType(String channelType) {
            this.channelType = channelType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
