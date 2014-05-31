package com.facebook.api;


class StatusSetResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<status_set_response>" + this.value + "</status_set_response>";
    }
}