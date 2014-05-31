package com.facebook.api;


class DataUndefineAssociationResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_undefineAssociation_response>" + this.value + "</data_undefineAssociation_response>";
    }
}