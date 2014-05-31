package com.facebook.api;


class DataIncHashValueResponse {
    private Integer value;

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_incHashValue_response>" + this.value + "</data_incHashValue_response>";
    }
}