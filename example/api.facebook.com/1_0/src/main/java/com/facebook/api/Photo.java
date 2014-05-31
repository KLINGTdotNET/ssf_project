package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Pid;
import com.facebook.api.Aid;
import com.facebook.api.Time;

class Photo  {


    private Pid pid;
    private Aid aid;
    private Uid owner;
    private String src;
    private String src_big;
    private String src_small;
    private String link;
    private String caption;
    private Time created;
    private Time modified;
    private Long object_id;


    public void setPid(Pid pid) {
        this.pid = pid;
    }

    public Pid getPid() {
        return this.pid;
    }
    public void setAid(Aid aid) {
        this.aid = aid;
    }

    public Aid getAid() {
        return this.aid;
    }
    public void setOwner(Uid owner) {
        this.owner = owner;
    }

    public Uid getOwner() {
        return this.owner;
    }
    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return this.src;
    }
    public void setSrcBig(String src_big) {
        this.src_big = src_big;
    }

    public String getSrcBig() {
        return this.src_big;
    }
    public void setSrcSmall(String src_small) {
        this.src_small = src_small;
    }

    public String getSrcSmall() {
        return this.src_small;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return this.caption;
    }
    public void setCreated(Time created) {
        this.created = created;
    }

    public Time getCreated() {
        return this.created;
    }
    public void setModified(Time modified) {
        this.modified = modified;
    }

    public Time getModified() {
        return this.modified;
    }
    public void setObjectId(Long object_id) {
        this.object_id = object_id;
    }

    public Long getObjectId() {
        return this.object_id;
    }

    public String toXML() {
        return this.pid.toXML() + this.aid.toXML() + this.owner.toXML() + "<src>" + this.src + "</src>" + "<src_big>" + this.src_big + "</src_big>" + "<src_small>" + this.src_small + "</src_small>" + "<link>" + this.link + "</link>" + "<caption>" + this.caption + "</caption>" + this.created.toXML() + this.modified.toXML() + "<object_id>" + this.object_id + "</object_id>";
    }
}