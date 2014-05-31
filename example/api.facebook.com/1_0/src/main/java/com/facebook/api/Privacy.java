package com.facebook.api;


class Privacy  {


    private String description;
    private String value;
    private String friends;


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getFriends() {
        return this.friends;
    }

    public String toXML() {
        return "<description>" + this.description + "</description>" + "<value>" + this.value + "</value>" + "<friends>" + this.friends + "</friends>";
    }
}