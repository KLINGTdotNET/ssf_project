package com.facebook.api;

import com.facebook.api.StreamMusic;
import com.facebook.api.StreamVideo;
import com.facebook.api.StreamPhoto;
import com.facebook.api.StreamSwf;

class StreamMedia  {


    private String href;
    private String alt;
    private String type;
    private String src;
    private StreamVideo video;
    private String obj;
    private StreamMusic music;
    private String data;
    private StreamPhoto photo;
    private StreamSwf swf;


    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return this.href;
    }
    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getAlt() {
        return this.alt;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return this.src;
    }
    public void setVideo(StreamVideo video) {
        this.video = video;
    }

    public StreamVideo getVideo() {
        return this.video;
    }
    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getObj() {
        return this.obj;
    }
    public void setMusic(StreamMusic music) {
        this.music = music;
    }

    public StreamMusic getMusic() {
        return this.music;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
    public void setPhoto(StreamPhoto photo) {
        this.photo = photo;
    }

    public StreamPhoto getPhoto() {
        return this.photo;
    }
    public void setSwf(StreamSwf swf) {
        this.swf = swf;
    }

    public StreamSwf getSwf() {
        return this.swf;
    }

    public String toXML() {
        return "<href>" + this.href + "</href>" + "<alt>" + this.alt + "</alt>" + "<type>" + this.type + "</type>" + "<src>" + this.src + "</src>" + this.video.toXML() + "<obj>" + this.obj + "</obj>" + this.music.toXML() + "<data>" + this.data + "</data>" + this.photo.toXML() + this.swf.toXML();
    }
}