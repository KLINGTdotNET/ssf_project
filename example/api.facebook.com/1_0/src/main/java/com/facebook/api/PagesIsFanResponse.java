package com.facebook.api;


class PagesIsFanResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<pages_isFan_response>" + this.value + "</pages_isFan_response>";
    }
}