package com.facebook.api;


class Arg  {


    private String key;
    private String value;


    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<key>" + this.key + "</key>" + "<value>" + this.value + "</value>";
    }
}