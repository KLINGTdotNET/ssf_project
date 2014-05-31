package com.facebook.api;

import com.facebook.api.Eid;

class EventsCreateResponse {
    private Eid value;

    public void setValue(Eid value) {
        this.value = value;
    }

    public Eid getValue() {
        return this.value;
    }

    public String toXML() {
        return "<events_create_response>" + this.value + "</events_create_response>";
    }
}