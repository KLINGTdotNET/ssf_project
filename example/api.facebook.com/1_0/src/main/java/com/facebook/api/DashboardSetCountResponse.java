package com.facebook.api;


class DashboardSetCountResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_setCount_response>" + this.value + "</dashboard_setCount_response>";
    }
}