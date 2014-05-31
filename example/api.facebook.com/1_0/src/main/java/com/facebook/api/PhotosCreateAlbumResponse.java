package com.facebook.api;

import com.facebook.api.Album;

class PhotosCreateAlbumResponse {
    private Album value;

    public void setValue(Album value) {
        this.value = value;
    }

    public Album getValue() {
        return this.value;
    }

    public String toXML() {
        return "<photos_createAlbum_response>" + this.value + "</photos_createAlbum_response>";
    }
}