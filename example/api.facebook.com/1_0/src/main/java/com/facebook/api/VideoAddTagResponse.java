package com.facebook.api;


class VideoAddTagResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<video_addTag_response>" + this.value + "</video_addTag_response>";
    }
}