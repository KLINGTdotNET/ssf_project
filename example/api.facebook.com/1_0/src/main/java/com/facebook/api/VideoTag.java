package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Vid;
import com.facebook.api.Time;

class VideoTag  {


    private Vid vid;
    private Uid subject;
    private Time created_time;
    private Time updated_time;


    public void setVid(Vid vid) {
        this.vid = vid;
    }

    public Vid getVid() {
        return this.vid;
    }
    public void setSubject(Uid subject) {
        this.subject = subject;
    }

    public Uid getSubject() {
        return this.subject;
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

    public String toXML() {
        return this.vid.toXML() + this.subject.toXML() + this.created_time.toXML() + this.updated_time.toXML();
    }
}