package com.facebook.api;


class DataDropObjectTypeResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_dropObjectType_response>" + this.value + "</data_dropObjectType_response>";
    }
}