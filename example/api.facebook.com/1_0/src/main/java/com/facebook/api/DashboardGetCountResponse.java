package com.facebook.api;


class DashboardGetCountResponse {
    private Integer value;

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_getCount_response>" + this.value + "</dashboard_getCount_response>";
    }
}