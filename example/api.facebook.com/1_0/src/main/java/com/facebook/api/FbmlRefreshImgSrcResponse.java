package com.facebook.api;


class FbmlRefreshImgSrcResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<fbml_refreshImgSrc_response>" + this.value + "</fbml_refreshImgSrc_response>";
    }
}