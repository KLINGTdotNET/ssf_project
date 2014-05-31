package com.facebook.api;


class AdminGetRestrictionInfoResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_getRestrictionInfo_response>" + this.value + "</admin_getRestrictionInfo_response>";
    }
}