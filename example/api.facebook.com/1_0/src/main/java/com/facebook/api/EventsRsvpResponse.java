package com.facebook.api;


class EventsRsvpResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<events_rsvp_response>" + this.value + "</events_rsvp_response>";
    }
}