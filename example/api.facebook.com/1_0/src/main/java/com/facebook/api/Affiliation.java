package com.facebook.api;

import com.facebook.api.Year;
import com.facebook.api.Nid;

class Affiliation  {


    private Nid nid;
    private String name;
    private String type;
    private String status;
    private Year year;


    public void setNid(Nid nid) {
        this.nid = nid;
    }

    public Nid getNid() {
        return this.nid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
    public void setYear(Year year) {
        this.year = year;
    }

    public Year getYear() {
        return this.year;
    }

    public String toXML() {
        return this.nid.toXML() + "<name>" + this.name + "</name>" + "<type>" + this.type + "</type>" + "<status>" + this.status + "</status>" + this.year.toXML();
    }
}