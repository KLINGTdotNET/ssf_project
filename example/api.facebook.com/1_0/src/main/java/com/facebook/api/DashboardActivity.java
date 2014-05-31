package com.facebook.api;

import com.facebook.api.Fbid;

class DashboardActivity  {


    private String image;
    private Fbid fbid;
    private Integer time;


    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }
    public void setFbid(Fbid fbid) {
        this.fbid = fbid;
    }

    public Fbid getFbid() {
        return this.fbid;
    }
    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getTime() {
        return this.time;
    }

    public String toXML() {
        return "<image>" + this.image + "</image>" + this.fbid.toXML() + "<time>" + this.time + "</time>";
    }
}