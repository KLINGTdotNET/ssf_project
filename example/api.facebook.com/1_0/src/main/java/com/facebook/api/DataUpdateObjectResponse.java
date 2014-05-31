package com.facebook.api;


class DataUpdateObjectResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_updateObject_response>" + this.value + "</data_updateObject_response>";
    }
}