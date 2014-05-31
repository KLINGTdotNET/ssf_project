package com.facebook.api;


class DataRemoveAssociationsResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_removeAssociations_response>" + this.value + "</data_removeAssociations_response>";
    }
}