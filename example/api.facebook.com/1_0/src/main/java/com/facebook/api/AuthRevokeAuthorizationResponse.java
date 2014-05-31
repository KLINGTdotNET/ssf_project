package com.facebook.api;


class AuthRevokeAuthorizationResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_revokeAuthorization_response>" + this.value + "</auth_revokeAuthorization_response>";
    }
}