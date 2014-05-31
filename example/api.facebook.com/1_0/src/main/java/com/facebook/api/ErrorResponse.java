package com.facebook.api;

import com.facebook.api.FacebookApiException;

class ErrorResponse {
    private FacebookApiException value;

    public void setValue(FacebookApiException value) {
        this.value = value;
    }

    public FacebookApiException getValue() {
        return this.value;
    }

    public String toXML() {
        return "<error_response>" + this.value + "</error_response>";
    }
}