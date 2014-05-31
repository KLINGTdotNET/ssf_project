package com.facebook.api;

import com.facebook.api.Privacy;

class PrivacyGetResponse {
    private Privacy value;

    public void setValue(Privacy value) {
        this.value = value;
    }

    public Privacy getValue() {
        return this.value;
    }

    public String toXML() {
        return "<privacy_get_response>" + this.value + "</privacy_get_response>";
    }
}