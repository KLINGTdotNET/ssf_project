package com.facebook.api;


class DataCreateObjectTypeResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_createObjectType_response>" + this.value + "</data_createObjectType_response>";
    }
}