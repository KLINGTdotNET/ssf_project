package com.facebook.api;

import com.facebook.api.VideoLimits;

class VideoGetUploadLimitsResponse {
    private VideoLimits value;

    public void setValue(VideoLimits value) {
        this.value = value;
    }

    public VideoLimits getValue() {
        return this.value;
    }

    public String toXML() {
        return "<video_getUploadLimits_response>" + this.value + "</video_getUploadLimits_response>";
    }
}