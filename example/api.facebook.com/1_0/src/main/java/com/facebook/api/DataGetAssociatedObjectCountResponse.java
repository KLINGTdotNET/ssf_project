package com.facebook.api;


class DataGetAssociatedObjectCountResponse {
    private Integer value;

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_getAssociatedObjectCount_response>" + this.value + "</data_getAssociatedObjectCount_response>";
    }
}