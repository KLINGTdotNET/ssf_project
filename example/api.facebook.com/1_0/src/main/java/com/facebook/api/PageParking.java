package com.facebook.api;


class PageParking  {


    private Boolean street;
    private Boolean lot;
    private Boolean valet;


    public void setStreet(Boolean street) {
        this.street = street;
    }

    public Boolean getStreet() {
        return this.street;
    }
    public void setLot(Boolean lot) {
        this.lot = lot;
    }

    public Boolean getLot() {
        return this.lot;
    }
    public void setValet(Boolean valet) {
        this.valet = valet;
    }

    public Boolean getValet() {
        return this.valet;
    }

    public String toXML() {
        return "<street>" + this.street + "</street>" + "<lot>" + this.lot + "</lot>" + "<valet>" + this.valet + "</valet>";
    }
}