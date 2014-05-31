package com.facebook.api;


class FbmlSetRefHandleResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<fbml_setRefHandle_response>" + this.value + "</fbml_setRefHandle_response>";
    }
}