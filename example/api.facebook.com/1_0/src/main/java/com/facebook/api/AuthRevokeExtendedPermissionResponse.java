package com.facebook.api;


class AuthRevokeExtendedPermissionResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<auth_revokeExtendedPermission_response>" + this.value + "</auth_revokeExtendedPermission_response>";
    }
}