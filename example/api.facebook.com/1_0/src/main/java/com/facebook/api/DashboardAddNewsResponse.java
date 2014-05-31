package com.facebook.api;

import com.facebook.api.Fbid;

class DashboardAddNewsResponse {
    private Fbid value;

    public void setValue(Fbid value) {
        this.value = value;
    }

    public Fbid getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_addNews_response>" + this.value + "</dashboard_addNews_response>";
    }
}