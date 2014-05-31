package com.facebook.api;


class UsersHasAppPermissionResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<users_hasAppPermission_response>" + this.value + "</users_hasAppPermission_response>";
    }
}