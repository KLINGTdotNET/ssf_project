package com.facebook.api;


class EventsInviteResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<events_invite_response>" + this.value + "</events_invite_response>";
    }
}