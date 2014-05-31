package com.facebook.api;

import com.facebook.api.Container;

class DashboardGetActivityResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_getActivity_response>" + this.value + "</dashboard_getActivity_response>";
    }
}