package com.unis.common_module.body;

import java.util.List;

public class AddMemberBody {
    private String groupId;
    private List<MemberBody> members;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<MemberBody> getMembers() {
        return members;
    }

    public void setMembers(List<MemberBody> members) {
        this.members = members;
    }
}
