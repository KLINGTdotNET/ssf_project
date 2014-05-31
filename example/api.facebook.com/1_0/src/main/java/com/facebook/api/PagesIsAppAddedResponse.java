package com.facebook.api;


class PagesIsAppAddedResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<pages_isAppAdded_response>" + this.value + "</pages_isAppAdded_response>";
    }
}