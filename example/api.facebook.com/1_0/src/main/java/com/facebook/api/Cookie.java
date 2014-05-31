package com.facebook.api;

import com.facebook.api.Uid;

class Cookie  {


    private Uid uid;
    private String name;
    private String value;
    private Integer expires;
    private String path;


    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    public void setExpires(Integer expires) {
        this.expires = expires;
    }

    public Integer getExpires() {
        return this.expires;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public String toXML() {
        return this.uid.toXML() + "<name>" + this.name + "</name>" + "<value>" + this.value + "</value>" + "<expires>" + this.expires + "</expires>" + "<path>" + this.path + "</path>";
    }
}