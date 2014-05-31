package com.facebook.api;

import com.facebook.api.TemplateBundle;

class FeedGetRegisteredTemplateBundleByIDResponse {
    private TemplateBundle value;

    public void setValue(TemplateBundle value) {
        this.value = value;
    }

    public TemplateBundle getValue() {
        return this.value;
    }

    public String toXML() {
        return "<feed_getRegisteredTemplateBundleByID_response>" + this.value + "</feed_getRegisteredTemplateBundleByID_response>";
    }
}