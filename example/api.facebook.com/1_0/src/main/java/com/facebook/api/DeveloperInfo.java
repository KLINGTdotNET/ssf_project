package com.facebook.api;


class DeveloperInfo  {


    private Integer uid;
    private String name;


    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return this.uid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toXML() {
        return "<uid>" + this.uid + "</uid>" + "<name>" + this.name + "</name>";
    }
}