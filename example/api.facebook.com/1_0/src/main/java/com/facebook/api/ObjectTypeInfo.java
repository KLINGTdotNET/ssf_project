package com.facebook.api;


class ObjectTypeInfo  {


    private String name;
    private Integer object_class;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setObjectClass(Integer object_class) {
        this.object_class = object_class;
    }

    public Integer getObjectClass() {
        return this.object_class;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<object_class>" + this.object_class + "</object_class>";
    }
}