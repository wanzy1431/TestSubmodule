package com.unis.common_module.body;

public
class ConversationModel {
    private String from;// 用户id
    private String fromSchoolId; // 用户学校id


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromSchoolId() {
        return fromSchoolId;
    }

    public void setFromSchoolId(String fromSchoolId) {
        this.fromSchoolId = fromSchoolId;
    }

}
