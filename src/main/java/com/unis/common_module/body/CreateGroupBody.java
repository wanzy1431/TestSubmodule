package com.unis.common_module.body;

import java.util.List;

public class CreateGroupBody {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerAccount() {
        return ownerAccount;
    }

    public void setOwnerAccount(String ownerAccount) {
        this.ownerAccount = ownerAccount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupTypeCode() {
        return groupTypeCode;
    }

    public void setGroupTypeCode(String groupTypeCode) {
        this.groupTypeCode = groupTypeCode;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public List<MemberBody> getMemberBodyList() {
        return members;
    }

    public void setMemberBodyList(List<MemberBody> members) {
        this.members = members;
    }

    private String type;
    private String ownerAccount;
    private String ownerName;
    private String name;
    private String groupTypeCode;
    private String schoolId;
    private List<MemberBody> members;
}
