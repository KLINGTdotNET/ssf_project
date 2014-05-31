package com.facebook.api;

import com.facebook.api.ThreadId;

class MessageCreateThreadResponse {
    private ThreadId value;

    public void setValue(ThreadId value) {
        this.value = value;
    }

    public ThreadId getValue() {
        return this.value;
    }

    public String toXML() {
        return "<message_createThread_response>" + this.value + "</message_createThread_response>";
    }
}