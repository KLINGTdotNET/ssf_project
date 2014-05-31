package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Eid;

class EventMember  {


    private Uid uid;
    private Eid oid;
    private String attending;


    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setOid(Eid oid) {
        this.oid = oid;
    }

    public Eid getOid() {
        return this.oid;
    }
    public void setAttending(String attending) {
        this.attending = attending;
    }

    public String getAttending() {
        return this.attending;
    }

    public String toXML() {
        return this.uid.toXML() + this.oid.toXML() + "<attending>" + this.attending + "</attending>";
    }
}