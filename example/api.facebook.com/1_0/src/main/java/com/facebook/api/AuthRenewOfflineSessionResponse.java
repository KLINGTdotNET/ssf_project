package com.facebook.api;

import com.facebook.api.SessionKey;

class AuthRenewOfflineSessionResponse {
    private SessionKey value;

    public void setValue(SessionKey value) {
        this.value = value;
    }

    public SessionKey getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_renewOfflineSession_response>" + this.value + "</auth_renewOfflineSession_response>";
    }
}