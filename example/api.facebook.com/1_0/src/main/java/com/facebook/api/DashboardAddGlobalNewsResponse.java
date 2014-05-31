package com.facebook.api;

import com.facebook.api.Fbid;

class DashboardAddGlobalNewsResponse {
    private Fbid value;

    public void setValue(Fbid value) {
        this.value = value;
    }

    public Fbid getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_addGlobalNews_response>" + this.value + "</dashboard_addGlobalNews_response>";
    }
}