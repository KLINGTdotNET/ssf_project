/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

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