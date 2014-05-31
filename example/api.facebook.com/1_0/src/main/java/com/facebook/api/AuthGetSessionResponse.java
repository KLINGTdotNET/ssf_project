package com.facebook.api;

import com.facebook.api.SessionInfo;

class AuthGetSessionResponse {
    private SessionInfo value;

    public void setValue(SessionInfo value) {
        this.value = value;
    }

    public SessionInfo getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_getSession_response>" + this.value + "</auth_getSession_response>";
    }
}