package com.facebook.api;


class DataRemoveHashKeysResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_removeHashKeys_response>" + this.value + "</data_removeHashKeys_response>";
    }
}