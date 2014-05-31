package com.facebook.api;

import com.facebook.api.Photo;

class PhotosUploadResponse {
    private Photo value;

    public void setValue(Photo value) {
        this.value = value;
    }

    public Photo getValue() {
        return this.value;
    }

    public String toXML() {
        return "<photos_upload_response>" + this.value + "</photos_upload_response>";
    }
}