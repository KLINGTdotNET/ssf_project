package com.facebook.api;

import com.facebook.api.GroupMembers;

class GroupsGetMembersResponse {
    private GroupMembers value;

    public void setValue(GroupMembers value) {
        this.value = value;
    }

    public GroupMembers getValue() {
        return this.value;
    }

    public String toXML() {
        return "<groups_getMembers_response>" + this.value + "</groups_getMembers_response>";
    }
}