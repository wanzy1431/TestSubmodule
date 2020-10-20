package com.unis.common_module.bean;

import java.io.Serializable;

public class TeacherDetailBean implements Serializable {
    private String userId;//用户id
    private String schoolId;//学校id

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
