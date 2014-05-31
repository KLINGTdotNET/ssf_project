package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Time;
import com.facebook.api.MessageId;
import com.facebook.api.StreamAttachment;

class Message  {


    private MessageId message_id;
    private Uid author_id;
    private String body;
    private Time created_time;
    private StreamAttachment attachment;


    public void setMessageId(MessageId message_id) {
        this.message_id = message_id;
    }

    public MessageId getMessageId() {
        return this.message_id;
    }
    public void setAuthorId(Uid author_id) {
        this.author_id = author_id;
    }

    public Uid getAuthorId() {
        return this.author_id;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }
    public void setCreatedTime(Time created_time) {
        this.created_time = created_time;
    }

    public Time getCreatedTime() {
        return this.created_time;
    }
    public void setAttachment(StreamAttachment attachment) {
        this.attachment = attachment;
    }

    public StreamAttachment getAttachment() {
        return this.attachment;
    }

    public String toXML() {
        return this.message_id.toXML() + this.author_id.toXML() + "<body>" + this.body + "</body>" + this.created_time.toXML() + this.attachment.toXML();
    }
}