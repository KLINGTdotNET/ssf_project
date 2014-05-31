package com.facebook.api;

import com.facebook.api.Container;

class MigrationsGetStatusesResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<migrations_getStatuses_response>" + this.value + "</migrations_getStatuses_response>";
    }
}