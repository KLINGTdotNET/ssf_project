package com.facebook.api;


class FbmlRegisterCustomTagsResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<fbml_registerCustomTags_response>" + this.value + "</fbml_registerCustomTags_response>";
    }
}