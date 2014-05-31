package com.facebook.api;


class PermissionsGrantApiAccessResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<permissions_grantApiAccess_response>" + this.value + "</permissions_grantApiAccess_response>";
    }
}