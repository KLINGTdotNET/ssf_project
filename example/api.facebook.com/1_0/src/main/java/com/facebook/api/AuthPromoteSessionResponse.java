package com.facebook.api;

import com.facebook.api.SessionSecret;

class AuthPromoteSessionResponse {
    private SessionSecret value;

    public void setValue(SessionSecret value) {
        this.value = value;
    }

    public SessionSecret getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_promoteSession_response>" + this.value + "</auth_promoteSession_response>";
    }
}