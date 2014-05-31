package com.facebook.api;


class StreamRemoveCommentResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<stream_removeComment_response>" + this.value + "</stream_removeComment_response>";
    }
}