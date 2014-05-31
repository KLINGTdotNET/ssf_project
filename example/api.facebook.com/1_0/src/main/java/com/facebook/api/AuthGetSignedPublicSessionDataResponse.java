package com.facebook.api;

import com.facebook.api.PublicSessionData;

class AuthGetSignedPublicSessionDataResponse {
    private PublicSessionData value;

    public void setValue(PublicSessionData value) {
        this.value = value;
    }

    public PublicSessionData getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_getSignedPublicSessionData_response>" + this.value + "</auth_getSignedPublicSessionData_response>";
    }
}