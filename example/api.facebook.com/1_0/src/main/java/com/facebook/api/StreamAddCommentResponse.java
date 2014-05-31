package com.facebook.api;


class StreamAddCommentResponse {
    private Long value;

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return this.value;
    }

    public String toXML() {
        return "<stream_addComment_response>" + this.value + "</stream_addComment_response>";
    }
}