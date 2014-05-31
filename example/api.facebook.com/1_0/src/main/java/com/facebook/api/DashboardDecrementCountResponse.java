package com.facebook.api;


class DashboardDecrementCountResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_decrementCount_response>" + this.value + "</dashboard_decrementCount_response>";
    }
}