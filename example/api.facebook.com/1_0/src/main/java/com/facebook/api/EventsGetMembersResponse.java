package com.facebook.api;

import com.facebook.api.EventMembers;

class EventsGetMembersResponse {
    private EventMembers value;

    public void setValue(EventMembers value) {
        this.value = value;
    }

    public EventMembers getValue() {
        return this.value;
    }

    public String toXML() {
        return "<events_getMembers_response>" + this.value + "</events_getMembers_response>";
    }
}