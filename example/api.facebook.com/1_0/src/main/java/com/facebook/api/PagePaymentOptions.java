package com.facebook.api;


class PagePaymentOptions  {


    private Boolean cash_only;
    private Boolean visa;
    private Boolean amex;
    private Boolean mastercard;
    private Boolean discover;


    public void setCashOnly(Boolean cash_only) {
        this.cash_only = cash_only;
    }

    public Boolean getCashOnly() {
        return this.cash_only;
    }
    public void setVisa(Boolean visa) {
        this.visa = visa;
    }

    public Boolean getVisa() {
        return this.visa;
    }
    public void setAmex(Boolean amex) {
        this.amex = amex;
    }

    public Boolean getAmex() {
        return this.amex;
    }
    public void setMastercard(Boolean mastercard) {
        this.mastercard = mastercard;
    }

    public Boolean getMastercard() {
        return this.mastercard;
    }
    public void setDiscover(Boolean discover) {
        this.discover = discover;
    }

    public Boolean getDiscover() {
        return this.discover;
    }

    public String toXML() {
        return "<cash_only>" + this.cash_only + "</cash_only>" + "<visa>" + this.visa + "</visa>" + "<amex>" + this.amex + "</amex>" + "<mastercard>" + this.mastercard + "</mastercard>" + "<discover>" + this.discover + "</discover>";
    }
}