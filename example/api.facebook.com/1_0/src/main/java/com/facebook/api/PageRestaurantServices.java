package com.facebook.api;


class PageRestaurantServices  {


    private Boolean reserve;
    private Boolean walkins;
    private Boolean groups;
    private Boolean kids;
    private Boolean takeout;
    private Boolean delivery;
    private Boolean catering;
    private Boolean waiter;
    private Boolean outdoor;


    public void setReserve(Boolean reserve) {
        this.reserve = reserve;
    }

    public Boolean getReserve() {
        return this.reserve;
    }
    public void setWalkins(Boolean walkins) {
        this.walkins = walkins;
    }

    public Boolean getWalkins() {
        return this.walkins;
    }
    public void setGroups(Boolean groups) {
        this.groups = groups;
    }

    public Boolean getGroups() {
        return this.groups;
    }
    public void setKids(Boolean kids) {
        this.kids = kids;
    }

    public Boolean getKids() {
        return this.kids;
    }
    public void setTakeout(Boolean takeout) {
        this.takeout = takeout;
    }

    public Boolean getTakeout() {
        return this.takeout;
    }
    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getDelivery() {
        return this.delivery;
    }
    public void setCatering(Boolean catering) {
        this.catering = catering;
    }

    public Boolean getCatering() {
        return this.catering;
    }
    public void setWaiter(Boolean waiter) {
        this.waiter = waiter;
    }

    public Boolean getWaiter() {
        return this.waiter;
    }
    public void setOutdoor(Boolean outdoor) {
        this.outdoor = outdoor;
    }

    public Boolean getOutdoor() {
        return this.outdoor;
    }

    public String toXML() {
        return "<reserve>" + this.reserve + "</reserve>" + "<walkins>" + this.walkins + "</walkins>" + "<groups>" + this.groups + "</groups>" + "<kids>" + this.kids + "</kids>" + "<takeout>" + this.takeout + "</takeout>" + "<delivery>" + this.delivery + "</delivery>" + "<catering>" + this.catering + "</catering>" + "<waiter>" + this.waiter + "</waiter>" + "<outdoor>" + this.outdoor + "</outdoor>";
    }
}