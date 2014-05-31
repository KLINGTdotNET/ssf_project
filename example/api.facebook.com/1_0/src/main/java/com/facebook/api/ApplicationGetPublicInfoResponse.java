package com.facebook.api;

import com.facebook.api.AppInfo;

class ApplicationGetPublicInfoResponse {
    private AppInfo value;

    public void setValue(AppInfo value) {
        this.value = value;
    }

    public AppInfo getValue() {
        return this.value;
    }

    public String toXML() {
        return "<application_getPublicInfo_response>" + this.value + "</application_getPublicInfo_response>";
    }
}