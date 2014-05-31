package com.facebook.api;


class DataSetHashValueResponse {
    private Long value;

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_setHashValue_response>" + this.value + "</data_setHashValue_response>";
    }
}