package com.facebook.api;


class DashboardIncrementCountResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_incrementCount_response>" + this.value + "</dashboard_incrementCount_response>";
    }
}