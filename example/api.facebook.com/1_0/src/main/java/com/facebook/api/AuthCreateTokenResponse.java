package com.facebook.api;

import com.facebook.api.AuthToken;

class AuthCreateTokenResponse {
    private AuthToken value;

    public void setValue(AuthToken value) {
        this.value = value;
    }

    public AuthToken getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_createToken_response>" + this.value + "</auth_createToken_response>";
    }
}