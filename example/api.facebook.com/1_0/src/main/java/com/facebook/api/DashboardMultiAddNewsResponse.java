package com.facebook.api;

import com.facebook.api.Container;

class DashboardMultiAddNewsResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_multiAddNews_response>" + this.value + "</dashboard_multiAddNews_response>";
    }
}