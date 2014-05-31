package com.facebook.api;


class StreamPublishResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<stream_publish_response>" + this.value + "</stream_publish_response>";
    }
}