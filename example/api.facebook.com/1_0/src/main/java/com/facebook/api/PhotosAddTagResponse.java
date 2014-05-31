package com.facebook.api;


class PhotosAddTagResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<photos_addTag_response>" + this.value + "</photos_addTag_response>";
    }
}