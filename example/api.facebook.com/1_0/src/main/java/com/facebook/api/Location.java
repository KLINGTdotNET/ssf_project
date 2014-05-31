package com.facebook.api;


class Location  {


    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private Double latitude;
    private Double longitude;
    private Long id;
    private String name;


    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return this.zip;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toXML() {
        return "<street>" + this.street + "</street>" + "<city>" + this.city + "</city>" + "<state>" + this.state + "</state>" + "<country>" + this.country + "</country>" + "<zip>" + this.zip + "</zip>" + "<latitude>" + this.latitude + "</latitude>" + "<longitude>" + this.longitude + "</longitude>" + "<id>" + this.id + "</id>" + "<name>" + this.name + "</name>";
    }
}