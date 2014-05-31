package com.facebook.api;


class AdminGetAllocationResponse {
    private Integer value;

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toXML() {
        return "<admin_getAllocation_response>" + this.value + "</admin_getAllocation_response>";
    }
}