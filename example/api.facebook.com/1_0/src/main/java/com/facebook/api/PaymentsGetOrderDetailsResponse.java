package com.facebook.api;


class PaymentsGetOrderDetailsResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<payments_getOrderDetails_response>" + this.value + "</payments_getOrderDetails_response>";
    }
}