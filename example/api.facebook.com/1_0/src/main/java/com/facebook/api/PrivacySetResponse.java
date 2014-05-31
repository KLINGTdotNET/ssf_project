package com.facebook.api;


class PrivacySetResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<privacy_set_response>" + this.value + "</privacy_set_response>";
    }
}