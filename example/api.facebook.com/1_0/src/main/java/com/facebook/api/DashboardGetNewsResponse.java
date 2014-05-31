package com.facebook.api;

import com.facebook.api.Container;

class DashboardGetNewsResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_getNews_response>" + this.value + "</dashboard_getNews_response>";
    }
}