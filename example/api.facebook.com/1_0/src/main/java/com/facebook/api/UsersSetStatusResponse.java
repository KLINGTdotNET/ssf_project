package com.facebook.api;


class UsersSetStatusResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<users_setStatus_response>" + this.value + "</users_setStatus_response>";
    }
}