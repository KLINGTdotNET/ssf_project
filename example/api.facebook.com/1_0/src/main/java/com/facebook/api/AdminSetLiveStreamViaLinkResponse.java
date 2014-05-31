package com.facebook.api;


class AdminSetLiveStreamViaLinkResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_setLiveStreamViaLink_response>" + this.value + "</admin_setLiveStreamViaLink_response>";
    }
}