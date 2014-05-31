package com.facebook.api;


class DataSetObjectPropertyResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_setObjectProperty_response>" + this.value + "</data_setObjectProperty_response>";
    }
}