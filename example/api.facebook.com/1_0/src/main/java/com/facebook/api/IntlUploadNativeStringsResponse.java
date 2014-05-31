package com.facebook.api;


class IntlUploadNativeStringsResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<intl_uploadNativeStrings_response>" + this.value + "</intl_uploadNativeStrings_response>";
    }
}