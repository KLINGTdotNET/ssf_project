package com.facebook.api;


class StreamSethiddenResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<stream_sethidden_response>" + this.value + "</stream_sethidden_response>";
    }
}