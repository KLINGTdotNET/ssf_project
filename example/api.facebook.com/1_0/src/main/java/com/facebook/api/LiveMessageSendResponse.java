package com.facebook.api;


class LiveMessageSendResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<liveMessage_send_response>" + this.value + "</liveMessage_send_response>";
    }
}