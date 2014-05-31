package com.facebook.api;


class FeedPublishTemplatizedActionResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<feed_publishTemplatizedAction_response>" + this.value + "</feed_publishTemplatizedAction_response>";
    }
}