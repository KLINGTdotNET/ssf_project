/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

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