package com.facebook.api;

import com.facebook.api.Date;
import com.facebook.api.Location;

class WorkInfo  {


    private Location location;
    private String company_name;
    private String position;
    private String description;
    private Date start_date;
    private Date end_date;


    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }
    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    public String getCompanyName() {
        return this.company_name;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }

    public Date getStartDate() {
        return this.start_date;
    }
    public void setEndDate(Date end_date) {
        this.end_date = end_date;
    }

    public Date getEndDate() {
        return this.end_date;
    }

    public String toXML() {
        return this.location.toXML() + "<company_name>" + this.company_name + "</company_name>" + "<position>" + this.position + "</position>" + "<description>" + this.description + "</description>" + this.start_date.toXML() + this.end_date.toXML();
    }
}