package com.facebook.api;


class PagesIsAdminResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<pages_isAdmin_response>" + this.value + "</pages_isAdmin_response>";
    }
}