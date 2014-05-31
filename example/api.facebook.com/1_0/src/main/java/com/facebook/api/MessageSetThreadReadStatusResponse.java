package com.facebook.api;


class MessageSetThreadReadStatusResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<message_setThreadReadStatus_response>" + this.value + "</message_setThreadReadStatus_response>";
    }
}