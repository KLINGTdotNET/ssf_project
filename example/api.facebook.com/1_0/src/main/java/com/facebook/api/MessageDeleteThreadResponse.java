package com.facebook.api;


class MessageDeleteThreadResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<message_deleteThread_response>" + this.value + "</message_deleteThread_response>";
    }
}