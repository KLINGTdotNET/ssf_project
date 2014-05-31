package com.facebook.api;

import com.facebook.api.Container;

class DashboardClearGlobalNewsResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_clearGlobalNews_response>" + this.value + "</dashboard_clearGlobalNews_response>";
    }
}