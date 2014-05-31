package com.facebook.api;


class UsersIsVerifiedResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<users_isVerified_response>" + this.value + "</users_isVerified_response>";
    }
}