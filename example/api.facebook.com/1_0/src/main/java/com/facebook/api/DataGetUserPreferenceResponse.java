package com.facebook.api;


class DataGetUserPreferenceResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_getUserPreference_response>" + this.value + "</data_getUserPreference_response>";
    }
}