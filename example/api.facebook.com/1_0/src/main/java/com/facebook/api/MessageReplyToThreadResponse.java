package com.facebook.api;

import com.facebook.api.MessageId;

class MessageReplyToThreadResponse {
    private MessageId value;

    public void setValue(MessageId value) {
        this.value = value;
    }

    public MessageId getValue() {
        return this.value;
    }

    public String toXML() {
        return "<message_replyToThread_response>" + this.value + "</message_replyToThread_response>";
    }
}