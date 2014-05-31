package com.facebook.api;


class StreamRemoveLikeResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<stream_removeLike_response>" + this.value + "</stream_removeLike_response>";
    }
}