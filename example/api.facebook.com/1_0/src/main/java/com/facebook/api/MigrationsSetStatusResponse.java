package com.facebook.api;


class MigrationsSetStatusResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<migrations_setStatus_response>" + this.value + "</migrations_setStatus_response>";
    }
}