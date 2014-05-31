package com.facebook.api;

import com.facebook.api.Uid;

class PublicSessionData  {


    private Uid uid;
    private String api_key;
    private Integer expires;
    private String sig;


    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setApiKey(String api_key) {
        this.api_key = api_key;
    }

    public String getApiKey() {
        return this.api_key;
    }
    public void setExpires(Integer expires) {
        this.expires = expires;
    }

    public Integer getExpires() {
        return this.expires;
    }
    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getSig() {
        return this.sig;
    }

    public String toXML() {
        return this.uid.toXML() + "<api_key>" + this.api_key + "</api_key>" + "<expires>" + this.expires + "</expires>" + "<sig>" + this.sig + "</sig>";
    }
}