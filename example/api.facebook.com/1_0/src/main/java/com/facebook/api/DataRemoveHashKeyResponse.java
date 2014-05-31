package com.facebook.api;


class DataRemoveHashKeyResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_removeHashKey_response>" + this.value + "</data_removeHashKey_response>";
    }
}