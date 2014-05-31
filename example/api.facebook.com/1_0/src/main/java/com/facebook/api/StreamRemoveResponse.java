package com.facebook.api;


class StreamRemoveResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<stream_remove_response>" + this.value + "</stream_remove_response>";
    }
}