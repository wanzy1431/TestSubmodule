package com.unis.common_module.bean;

import java.util.List;

public class GroupContentBean {
    private String operatorId;
    private String operatorName;
    private List<MembersBean> members;
    private List<MembersBean> manager;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public List<MembersBean> getMembers() {
        return members;
    }

    public void setMembers(List<MembersBean> members) {
        this.members = members;
    }

    public List<MembersBean> getManager() {
        return manager;
    }

    public void setManager(List<MembersBean> manager) {
        this.manager = manager;
    }

    public static class MembersBean {
        /**
         * userId : 1000000000003138024
         * userName : IM教师8
         */

        private String userId;
        private String userName;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
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
