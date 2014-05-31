package com.facebook.api;


class DataRenameAssociationResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_renameAssociation_response>" + this.value + "</data_renameAssociation_response>";
    }
}