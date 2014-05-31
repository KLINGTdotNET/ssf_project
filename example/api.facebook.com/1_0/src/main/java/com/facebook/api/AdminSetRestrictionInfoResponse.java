package com.facebook.api;


class AdminSetRestrictionInfoResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_setRestrictionInfo_response>" + this.value + "</admin_setRestrictionInfo_response>";
    }
}