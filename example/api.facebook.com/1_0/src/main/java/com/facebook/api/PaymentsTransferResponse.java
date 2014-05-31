package com.facebook.api;


class PaymentsTransferResponse {
    private Long value;

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return this.value;
    }

    public String toXML() {
        return "<payments_transfer_response>" + this.value + "</payments_transfer_response>";
    }
}