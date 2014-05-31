package com.facebook.api;


class DataRemoveAssociationResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_removeAssociation_response>" + this.value + "</data_removeAssociation_response>";
    }
}