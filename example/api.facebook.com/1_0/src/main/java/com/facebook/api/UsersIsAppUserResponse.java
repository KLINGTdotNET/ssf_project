package com.facebook.api;


class UsersIsAppUserResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<users_isAppUser_response>" + this.value + "</users_isAppUser_response>";
    }
}