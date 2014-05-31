package com.facebook.api;


class PaymentsGetOrdersResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<payments_getOrders_response>" + this.value + "</payments_getOrders_response>";
    }
}