package com.facebook.api;


class JsonString  {

    private String value;


    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


    public String toXML() {
        return value.toString();
    }
}