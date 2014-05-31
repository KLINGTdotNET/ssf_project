package com.facebook.api;


class VideoRemoveTagResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<video_removeTag_response>" + this.value + "</video_removeTag_response>";
    }
}