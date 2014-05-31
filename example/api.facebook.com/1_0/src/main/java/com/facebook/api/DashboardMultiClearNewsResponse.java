package com.facebook.api;

import com.facebook.api.Container;

class DashboardMultiClearNewsResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_multiClearNews_response>" + this.value + "</dashboard_multiClearNews_response>";
    }
}