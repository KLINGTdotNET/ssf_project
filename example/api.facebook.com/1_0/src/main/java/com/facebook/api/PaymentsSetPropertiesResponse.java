package com.facebook.api;


class PaymentsSetPropertiesResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<payments_setProperties_response>" + this.value + "</payments_setProperties_response>";
    }
}