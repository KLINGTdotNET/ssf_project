package com.facebook.api;

import com.facebook.api.StreamAttachment;

class LinksPreviewResponse {
    private StreamAttachment value;

    public void setValue(StreamAttachment value) {
        this.value = value;
    }

    public StreamAttachment getValue() {
        return this.value;
    }

    public String toXML() {
        return "<links_preview_response>" + this.value + "</links_preview_response>";
    }
}