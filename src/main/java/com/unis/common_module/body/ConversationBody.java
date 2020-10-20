package com.unis.common_module.body;

public
class ConversationBody {
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

    public String getUserSchoolId() {
        return userSchoolId;
    }

    public void setUserSchoolId(String userSchoolId) {
        this.userSchoolId = userSchoolId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToSchoolId() {
        return toSchoolId;
    }

    public void setToSchoolId(String toSchoolId) {
        this.toSchoolId = toSchoolId;
    }

    private String userId;
    private String userName;
    private String userSchoolId;
    private String toId;
    private String toName;
    private String toSchoolId;

}
