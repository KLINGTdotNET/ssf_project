package com.facebook.api;

import com.facebook.api.Uid;

class UsersGetLoggedInUserResponse {
    private Uid value;

    public void setValue(Uid value) {
        this.value = value;
    }

    public Uid getValue() {
        return this.value;
    }

    public String toXML() {
        return "<users_getLoggedInUser_response>" + this.value + "</users_getLoggedInUser_response>";
    }
}