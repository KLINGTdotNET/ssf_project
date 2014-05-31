package com.facebook.api;


class FeedDeactivateTemplateBundleByIDResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<feed_deactivateTemplateBundleByID_response>" + this.value + "</feed_deactivateTemplateBundleByID_response>";
    }
}