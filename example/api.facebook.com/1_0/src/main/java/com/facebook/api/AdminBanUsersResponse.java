package com.facebook.api;


class AdminBanUsersResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_banUsers_response>" + this.value + "</admin_banUsers_response>";
    }
}