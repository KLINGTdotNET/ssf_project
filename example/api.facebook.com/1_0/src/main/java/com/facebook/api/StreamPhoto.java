package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Pid;
import com.facebook.api.Aid;

class StreamPhoto  {


    private Aid aid;
    private Pid pid;
    private Uid owner;
    private Integer index;
    private Integer width;
    private Integer height;


    public void setAid(Aid aid) {
        this.aid = aid;
    }

    public Aid getAid() {
        return this.aid;
    }
    public void setPid(Pid pid) {
        this.pid = pid;
    }

    public Pid getPid() {
        return this.pid;
    }
    public void setOwner(Uid owner) {
        this.owner = owner;
    }

    public Uid getOwner() {
        return this.owner;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return this.index;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return this.width;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return this.height;
    }

    public String toXML() {
        return this.aid.toXML() + this.pid.toXML() + this.owner.toXML() + "<index>" + this.index + "</index>" + "<width>" + this.width + "</width>" + "<height>" + this.height + "</height>";
    }
}