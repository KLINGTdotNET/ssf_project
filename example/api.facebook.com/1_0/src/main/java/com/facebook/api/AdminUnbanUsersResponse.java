package com.facebook.api;


class AdminUnbanUsersResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_unbanUsers_response>" + this.value + "</admin_unbanUsers_response>";
    }
}