package com.facebook.api;


class UsersIsAppAddedResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<users_isAppAdded_response>" + this.value + "</users_isAppAdded_response>";
    }
}