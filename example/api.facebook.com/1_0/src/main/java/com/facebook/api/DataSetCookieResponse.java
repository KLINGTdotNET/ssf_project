package com.facebook.api;


class DataSetCookieResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_setCookie_response>" + this.value + "</data_setCookie_response>";
    }
}