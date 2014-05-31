package com.facebook.api;


class EventsCancelResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<events_cancel_response>" + this.value + "</events_cancel_response>";
    }
}