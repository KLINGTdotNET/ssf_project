package com.facebook.api;


class AdminSetAppPropertiesResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_setAppProperties_response>" + this.value + "</admin_setAppProperties_response>";
    }
}