/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;

import com.facebook.api.Time;

class ObjectAssociation  {


    private String name;
    private Long id1;
    private Long id2;
    private String data;
    private Time time;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId1() {
        return this.id1;
    }
    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public Long getId2() {
        return this.id2;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return this.time;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<id1>" + this.id1 + "</id1>" + "<id2>" + this.id2 + "</id2>" + "<data>" + this.data + "</data>" + this.time.toXML();
    }
}