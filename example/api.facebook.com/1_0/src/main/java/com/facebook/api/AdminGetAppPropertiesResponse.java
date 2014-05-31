package com.facebook.api;


class AdminGetAppPropertiesResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_getAppProperties_response>" + this.value + "</admin_getAppProperties_response>";
    }
}