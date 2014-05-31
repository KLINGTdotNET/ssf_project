package com.facebook.api;


class DataSetAssociationsResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_setAssociations_response>" + this.value + "</data_setAssociations_response>";
    }
}