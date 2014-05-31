package com.facebook.api;


class FeedPublishUserActionResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<feed_publishUserAction_response>" + this.value + "</feed_publishUserAction_response>";
    }
}