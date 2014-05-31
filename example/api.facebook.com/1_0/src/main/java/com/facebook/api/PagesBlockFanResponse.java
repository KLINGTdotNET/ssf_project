package com.facebook.api;


class PagesBlockFanResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<pages_blockFan_response>" + this.value + "</pages_blockFan_response>";
    }
}