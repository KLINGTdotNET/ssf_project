package com.facebook.api;


class FbmlDeleteCustomTagsResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<fbml_deleteCustomTags_response>" + this.value + "</fbml_deleteCustomTags_response>";
    }
}