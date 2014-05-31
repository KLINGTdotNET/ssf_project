package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Flid;

class FriendlistMember  {


    private Flid flid;
    private Uid uid;


    public void setFlid(Flid flid) {
        this.flid = flid;
    }

    public Flid getFlid() {
        return this.flid;
    }
    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }

    public String toXML() {
        return this.flid.toXML() + this.uid.toXML();
    }
}