package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Gid;

class GroupMember  {


    private Uid uid;
    private Gid gid;


    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setGid(Gid gid) {
        this.gid = gid;
    }

    public Gid getGid() {
        return this.gid;
    }

    public String toXML() {
        return this.uid.toXML() + this.gid.toXML();
    }
}