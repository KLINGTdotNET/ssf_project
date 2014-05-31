package com.facebook.api;


class DataGetHashValueResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_getHashValue_response>" + this.value + "</data_getHashValue_response>";
    }
}