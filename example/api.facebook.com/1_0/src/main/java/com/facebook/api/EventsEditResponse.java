package com.facebook.api;


class EventsEditResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<events_edit_response>" + this.value + "</events_edit_response>";
    }
}