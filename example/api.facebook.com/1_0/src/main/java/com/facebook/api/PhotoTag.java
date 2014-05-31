package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Pid;
import com.facebook.api.Time;

class PhotoTag  {


    private Pid pid;
    private Uid subject;
    private String text;
    private Double xcoord;
    private Double ycoord;
    private Time created;


    public void setPid(Pid pid) {
        this.pid = pid;
    }

    public Pid getPid() {
        return this.pid;
    }
    public void setSubject(Uid subject) {
        this.subject = subject;
    }

    public Uid getSubject() {
        return this.subject;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    public void setXcoord(Double xcoord) {
        this.xcoord = xcoord;
    }

    public Double getXcoord() {
        return this.xcoord;
    }
    public void setYcoord(Double ycoord) {
        this.ycoord = ycoord;
    }

    public Double getYcoord() {
        return this.ycoord;
    }
    public void setCreated(Time created) {
        this.created = created;
    }

    public Time getCreated() {
        return this.created;
    }

    public String toXML() {
        return this.pid.toXML() + this.subject.toXML() + "<text>" + this.text + "</text>" + "<xcoord>" + this.xcoord + "</xcoord>" + "<ycoord>" + this.ycoord + "</ycoord>" + this.created.toXML();
    }
}