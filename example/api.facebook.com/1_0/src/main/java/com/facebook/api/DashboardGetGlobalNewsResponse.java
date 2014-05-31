package com.facebook.api;

import com.facebook.api.Container;

class DashboardGetGlobalNewsResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_getGlobalNews_response>" + this.value + "</dashboard_getGlobalNews_response>";
    }
}