package com.facebook.api;


class AdminGetLiveStreamViaLinkResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_getLiveStreamViaLink_response>" + this.value + "</admin_getLiveStreamViaLink_response>";
    }
}