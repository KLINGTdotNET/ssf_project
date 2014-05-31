package com.facebook.api;


class DataRenameObjectPropertyResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_renameObjectProperty_response>" + this.value + "</data_renameObjectProperty_response>";
    }
}