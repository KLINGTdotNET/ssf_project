package com.facebook.api;


class DataRenameObjectTypeResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_renameObjectType_response>" + this.value + "</data_renameObjectType_response>";
    }
}