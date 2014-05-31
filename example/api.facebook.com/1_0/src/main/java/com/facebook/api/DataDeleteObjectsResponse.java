package com.facebook.api;


class DataDeleteObjectsResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_deleteObjects_response>" + this.value + "</data_deleteObjects_response>";
    }
}