package com.facebook.api;


class DataDefineObjectPropertyResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_defineObjectProperty_response>" + this.value + "</data_defineObjectProperty_response>";
    }
}