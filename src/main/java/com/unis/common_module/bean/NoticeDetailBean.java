package com.unis.common_module.bean;

import java.util.List;

public class NoticeDetailBean {

    /**
     * id : 1000100000021877007
     * createTime : 2020-09-22 17:07:00
     * creator : 1000000000003138009
     * updateTime : 2020-09-22 17:07:00
     * modificator : 1000000000003138009
     * groupId : 1000100000021867001
     * noticeContent : jdhhdhdh
     * topped : 0
     * readCount : 1
     * unreadCount : 3
     * readUsers : [{"userId":"1000000000003138009","createTime":null,"groupCount":null,"friendCount":null,"userSign":null,"channelType":null,"userName":"IM教师3","nickName":null,"schoolId":null}]
     * unreadUsers : [{"userId":"1000000000003138006","createTime":null,"groupCount":null,"friendCount":null,"userSign":null,"channelType":null,"userName":"IM教师2","nickName":"IM教师2","schoolId":"1000000000000587269"},{"userId":"1000000000003061053","createTime":null,"groupCount":null,"friendCount":null,"userSign":null,"channelType":null,"userName":"IM教师11","nickName":"IM教师11","schoolId":"1000000000000587269"},{"userId":"1000000000003061054","createTime":null,"groupCount":null,"friendCount":null,"userSign":null,"channelType":null,"userName":"IM教师12","nickName":"IM教师12","schoolId":"1000000000000587269"}]
     * operator : {"userId":"1000000000003138009","createTime":"2020-09-18 17:30:49","groupCount":null,"friendCount":null,"userSign":null,"channelType":null,"userName":"IM教师3","nickName":null,"schoolId":null}
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
    private int unreadCount;
    private OperatorBean operator;
    private List<NoticeReadBean> readUsers;
    private List<NoticeReadBean> unreadUsers;

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

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public OperatorBean getOperator() {
        return operator;
    }

    public void setOperator(OperatorBean operator) {
        this.operator = operator;
    }

    public List<NoticeReadBean> getReadUsers() {
        return readUsers;
    }

    public void setReadUsers(List<NoticeReadBean> readUsers) {
        this.readUsers = readUsers;
    }

    public List<NoticeReadBean> getUnreadUsers() {
        return unreadUsers;
    }

    public void setUnreadUsers(List<NoticeReadBean> unreadUsers) {
        this.unreadUsers = unreadUsers;
    }

    public static class OperatorBean {
        /**
         * userId : 1000000000003138009
         * createTime : 2020-09-18 17:30:49
         * groupCount : null
         * friendCount : null
         * userSign : null
         * channelType : null
         * userName : IM教师3
         * nickName : null
         * schoolId : null
         */

        private String userId;
        private String createTime;
        private Object groupCount;
        private Object friendCount;
        private Object userSign;
        private Object channelType;
        private String userName;
        private Object nickName;
        private Object schoolId;

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

        public Object getGroupCount() {
            return groupCount;
        }

        public void setGroupCount(Object groupCount) {
            this.groupCount = groupCount;
        }

        public Object getFriendCount() {
            return friendCount;
        }

        public void setFriendCount(Object friendCount) {
            this.friendCount = friendCount;
        }

        public Object getUserSign() {
            return userSign;
        }

        public void setUserSign(Object userSign) {
            this.userSign = userSign;
        }

        public Object getChannelType() {
            return channelType;
        }

        public void setChannelType(Object channelType) {
            this.channelType = channelType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getNickName() {
            return nickName;
        }

        public void setNickName(Object nickName) {
            this.nickName = nickName;
        }

        public Object getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(Object schoolId) {
            this.schoolId = schoolId;
        }
    }

    public static class ReadUsersBean {
        /**
         * userId : 1000000000003138009
         * createTime : null
         * groupCount : null
         * friendCount : null
         * userSign : null
         * channelType : null
         * userName : IM教师3
         * nickName : null
         * schoolId : null
         */

        private String userId;
        private Object createTime;
        private Object groupCount;
        private Object friendCount;
        private Object userSign;
        private Object channelType;
        private String userName;
        private Object nickName;
        private Object schoolId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getGroupCount() {
            return groupCount;
        }

        public void setGroupCount(Object groupCount) {
            this.groupCount = groupCount;
        }

        public Object getFriendCount() {
            return friendCount;
        }

        public void setFriendCount(Object friendCount) {
            this.friendCount = friendCount;
        }

        public Object getUserSign() {
            return userSign;
        }

        public void setUserSign(Object userSign) {
            this.userSign = userSign;
        }

        public Object getChannelType() {
            return channelType;
        }

        public void setChannelType(Object channelType) {
            this.channelType = channelType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getNickName() {
            return nickName;
        }

        public void setNickName(Object nickName) {
            this.nickName = nickName;
        }

        public Object getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(Object schoolId) {
            this.schoolId = schoolId;
        }
    }

    public static class UnreadUsersBean {
        /**
         * userId : 1000000000003138006
         * createTime : null
         * groupCount : null
         * friendCount : null
         * userSign : null
         * channelType : null
         * userName : IM教师2
         * nickName : IM教师2
         * schoolId : 1000000000000587269
         */

        private String userId;
        private Object createTime;
        private Object groupCount;
        private Object friendCount;
        private Object userSign;
        private Object channelType;
        private String userName;
        private String nickName;
        private String schoolId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getGroupCount() {
            return groupCount;
        }

        public void setGroupCount(Object groupCount) {
            this.groupCount = groupCount;
        }

        public Object getFriendCount() {
            return friendCount;
        }

        public void setFriendCount(Object friendCount) {
            this.friendCount = friendCount;
        }

        public Object getUserSign() {
            return userSign;
        }

        public void setUserSign(Object userSign) {
            this.userSign = userSign;
        }

        public Object getChannelType() {
            return channelType;
        }

        public void setChannelType(Object channelType) {
            this.channelType = channelType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(String schoolId) {
            this.schoolId = schoolId;
        }
    }
}
