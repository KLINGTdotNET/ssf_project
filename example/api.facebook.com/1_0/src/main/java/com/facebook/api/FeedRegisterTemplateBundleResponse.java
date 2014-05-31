package com.facebook.api;

import com.facebook.api.Tbid;

class FeedRegisterTemplateBundleResponse {
    private Tbid value;

    public void setValue(Tbid value) {
        this.value = value;
    }

    public Tbid getValue() {
        return this.value;
    }

    public String toXML() {
        return "<feed_registerTemplateBundle_response>" + this.value + "</feed_registerTemplateBundle_response>";
    }
}