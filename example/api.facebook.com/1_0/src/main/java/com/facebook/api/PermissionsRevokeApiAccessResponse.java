package com.facebook.api;


class PermissionsRevokeApiAccessResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<permissions_revokeApiAccess_response>" + this.value + "</permissions_revokeApiAccess_response>";
    }
}