package com.facebook.api;


class DataDefineAssociationResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_defineAssociation_response>" + this.value + "</data_defineAssociation_response>";
    }
}