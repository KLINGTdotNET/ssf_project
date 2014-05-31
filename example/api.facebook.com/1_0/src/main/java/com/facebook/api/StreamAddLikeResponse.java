package com.facebook.api;


class StreamAddLikeResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<stream_addLike_response>" + this.value + "</stream_addLike_response>";
    }
}