package com.facebook.api;


class PaymentsUpdateOrderResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<payments_updateOrder_response>" + this.value + "</payments_updateOrder_response>";
    }
}