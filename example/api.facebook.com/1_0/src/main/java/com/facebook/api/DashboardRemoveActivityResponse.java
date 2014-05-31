package com.facebook.api;

import com.facebook.api.Container;

class DashboardRemoveActivityResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_removeActivity_response>" + this.value + "</dashboard_removeActivity_response>";
    }
}