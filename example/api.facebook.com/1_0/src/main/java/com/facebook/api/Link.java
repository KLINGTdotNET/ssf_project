package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.LinkId;
import com.facebook.api.Time;

class Link  {


    private LinkId link_id;
    private Uid owner;
    private String owner_comment;
    private Time created_time;
    private String title;
    private String summary;
    private String url;


    public void setLinkId(LinkId link_id) {
        this.link_id = link_id;
    }

    public LinkId getLinkId() {
        return this.link_id;
    }
    public void setOwner(Uid owner) {
        this.owner = owner;
    }

    public Uid getOwner() {
        return this.owner;
    }
    public void setOwnerComment(String owner_comment) {
        this.owner_comment = owner_comment;
    }

    public String getOwnerComment() {
        return this.owner_comment;
    }
    public void setCreatedTime(Time created_time) {
        this.created_time = created_time;
    }

    public Time getCreatedTime() {
        return this.created_time;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return this.summary;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public String toXML() {
        return this.link_id.toXML() + this.owner.toXML() + "<owner_comment>" + this.owner_comment + "</owner_comment>" + this.created_time.toXML() + "<title>" + this.title + "</title>" + "<summary>" + this.summary + "</summary>" + "<url>" + this.url + "</url>";
    }
}