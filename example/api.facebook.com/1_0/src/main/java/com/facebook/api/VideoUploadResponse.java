package com.facebook.api;

import com.facebook.api.Video;

class VideoUploadResponse {
    private Video value;

    public void setValue(Video value) {
        this.value = value;
    }

    public Video getValue() {
        return this.value;
    }

    public String toXML() {
        return "<video_upload_response>" + this.value + "</video_upload_response>";
    }
}