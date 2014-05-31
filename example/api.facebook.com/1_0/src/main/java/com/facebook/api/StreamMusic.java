package com.facebook.api;


class StreamMusic  {


    private String source_url;
    private String title;
    private String artist;
    private String album;


    public void setSourceUrl(String source_url) {
        this.source_url = source_url;
    }

    public String getSourceUrl() {
        return this.source_url;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return this.artist;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbum() {
        return this.album;
    }

    public String toXML() {
        return "<source_url>" + this.source_url + "</source_url>" + "<title>" + this.title + "</title>" + "<artist>" + this.artist + "</artist>" + "<album>" + this.album + "</album>";
    }
}