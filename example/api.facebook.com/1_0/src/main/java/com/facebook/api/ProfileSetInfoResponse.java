package com.facebook.api;


class ProfileSetInfoResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<profile_setInfo_response>" + this.value + "</profile_setInfo_response>";
    }
}