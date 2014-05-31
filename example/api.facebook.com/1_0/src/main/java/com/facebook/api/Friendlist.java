package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Flid;

class Friendlist  {


    private Flid flid;
    private String name;
    private Uid owner;


    public void setFlid(Flid flid) {
        this.flid = flid;
    }

    public Flid getFlid() {
        return this.flid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setOwner(Uid owner) {
        this.owner = owner;
    }

    public Uid getOwner() {
        return this.owner;
    }

    public String toXML() {
        return this.flid.toXML() + "<name>" + this.name + "</name>" + this.owner.toXML();
    }
}