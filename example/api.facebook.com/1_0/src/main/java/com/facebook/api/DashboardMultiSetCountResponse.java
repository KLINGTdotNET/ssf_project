package com.facebook.api;

import com.facebook.api.Container;

class DashboardMultiSetCountResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_multiSetCount_response>" + this.value + "</dashboard_multiSetCount_response>";
    }
}