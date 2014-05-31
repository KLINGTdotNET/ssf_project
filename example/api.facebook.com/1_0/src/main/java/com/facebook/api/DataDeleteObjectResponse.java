package com.facebook.api;


class DataDeleteObjectResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_deleteObject_response>" + this.value + "</data_deleteObject_response>";
    }
}