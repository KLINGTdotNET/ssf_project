package com.facebook.api;

import com.facebook.api.StreamData;

class StreamGetResponse {
    private StreamData value;

    public void setValue(StreamData value) {
        this.value = value;
    }

    public StreamData getValue() {
        return this.value;
    }

    public String toXML() {
        return "<stream_get_response>" + this.value + "</stream_get_response>";
    }
}