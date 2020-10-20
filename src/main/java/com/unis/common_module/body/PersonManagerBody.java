package com.unis.common_module.body;

public class PersonManagerBody {
    private String toId;
    private String toName;
    private String toSchoolId;
    private String conversationId;
    private boolean isNotDisturb;

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

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public boolean isNotDisturb() {
        return isNotDisturb;
    }

    public void setNotDisturb(boolean notDisturb) {
        isNotDisturb = notDisturb;
    }
}
