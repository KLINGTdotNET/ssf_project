package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Vid;
import com.facebook.api.Time;

class Video  {


    private Vid vid;
    private String title;
    private String description;
    private String link;
    private Uid owner;
    private String thumbnail_link;
    private String embed_html;
    private Time created_time;
    private Time updated_time;
    private Integer length;


    public void setVid(Vid vid) {
        this.vid = vid;
    }

    public Vid getVid() {
        return this.vid;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
    public void setOwner(Uid owner) {
        this.owner = owner;
    }

    public Uid getOwner() {
        return this.owner;
    }
    public void setThumbnailLink(String thumbnail_link) {
        this.thumbnail_link = thumbnail_link;
    }

    public String getThumbnailLink() {
        return this.thumbnail_link;
    }
    public void setEmbedHtml(String embed_html) {
        this.embed_html = embed_html;
    }

    public String getEmbedHtml() {
        return this.embed_html;
    }
    public void setCreatedTime(Time created_time) {
        this.created_time = created_time;
    }

    public Time getCreatedTime() {
        return this.created_time;
    }
    public void setUpdatedTime(Time updated_time) {
        this.updated_time = updated_time;
    }

    public Time getUpdatedTime() {
        return this.updated_time;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLength() {
        return this.length;
    }

    public String toXML() {
        return this.vid.toXML() + "<title>" + this.title + "</title>" + "<description>" + this.description + "</description>" + "<link>" + this.link + "</link>" + this.owner.toXML() + "<thumbnail_link>" + this.thumbnail_link + "</thumbnail_link>" + "<embed_html>" + this.embed_html + "</embed_html>" + this.created_time.toXML() + this.updated_time.toXML() + "<length>" + this.length + "</length>";
    }
}