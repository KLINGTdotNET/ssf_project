package com.facebook.api;


class AuthExpireSessionResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_expireSession_response>" + this.value + "</auth_expireSession_response>";
    }
}