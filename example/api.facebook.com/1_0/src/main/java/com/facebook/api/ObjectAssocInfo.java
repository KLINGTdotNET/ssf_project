package com.facebook.api;

import com.facebook.api.AssocObjectType;

class ObjectAssocInfo  {


    private String name;
    private Integer assoc_type;
    private AssocObjectType assoc_info1;
    private AssocObjectType assoc_info2;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setAssocType(Integer assoc_type) {
        this.assoc_type = assoc_type;
    }

    public Integer getAssocType() {
        return this.assoc_type;
    }
    public void setAssocInfo1(AssocObjectType assoc_info1) {
        this.assoc_info1 = assoc_info1;
    }

    public AssocObjectType getAssocInfo1() {
        return this.assoc_info1;
    }
    public void setAssocInfo2(AssocObjectType assoc_info2) {
        this.assoc_info2 = assoc_info2;
    }

    public AssocObjectType getAssocInfo2() {
        return this.assoc_info2;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<assoc_type>" + this.assoc_type + "</assoc_type>" + this.assoc_info1.toXML() + this.assoc_info2.toXML();
    }
}