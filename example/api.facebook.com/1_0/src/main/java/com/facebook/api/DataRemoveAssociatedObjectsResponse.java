package com.facebook.api;


class DataRemoveAssociatedObjectsResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_removeAssociatedObjects_response>" + this.value + "</data_removeAssociatedObjects_response>";
    }
}