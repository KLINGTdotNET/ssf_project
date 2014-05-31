package com.facebook.api;

import com.facebook.api.Container;

class DashboardMultiGetCountResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_multiGetCount_response>" + this.value + "</dashboard_multiGetCount_response>";
    }
}