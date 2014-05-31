package com.facebook.api;


class Year  {

    private Integer value;


    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }


    public String toXML() {
        return value.toString();
    }
}