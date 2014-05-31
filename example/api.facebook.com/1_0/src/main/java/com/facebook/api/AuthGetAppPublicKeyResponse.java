package com.facebook.api;


class AuthGetAppPublicKeyResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_getAppPublicKey_response>" + this.value + "</auth_getAppPublicKey_response>";
    }
}