package com.unis.common_module.bean;

public class DisturbBean {
    private String from;
    private String fromSchoolId;
    private String to;
    private String toSchoolId;
    private boolean isNotDisturb;

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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToSchoolId() {
        return toSchoolId;
    }

    public void setToSchoolId(String toSchoolId) {
        this.toSchoolId = toSchoolId;
    }

    public boolean isIsNotDisturb() {
        return isNotDisturb;
    }

    public void setIsNotDisturb(boolean isNotDisturb) {
        this.isNotDisturb = isNotDisturb;
    }
}
