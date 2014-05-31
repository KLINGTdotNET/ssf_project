package com.facebook.api;


class DataCreateObjectResponse {
    private Long value;

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_createObject_response>" + this.value + "</data_createObject_response>";
    }
}