package com.facebook.api;


class DataGetObjectPropertyResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_getObjectProperty_response>" + this.value + "</data_getObjectProperty_response>";
    }
}