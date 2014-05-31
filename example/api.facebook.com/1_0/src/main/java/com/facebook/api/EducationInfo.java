package com.facebook.api;

import com.facebook.api.Year;

class EducationInfo  {


    private String name;
    private Year year;
    private String degree;
    private String school_type;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setYear(Year year) {
        this.year = year;
    }

    public Year getYear() {
        return this.year;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return this.degree;
    }
    public void setSchoolType(String school_type) {
        this.school_type = school_type;
    }

    public String getSchoolType() {
        return this.school_type;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + this.year.toXML() + "<degree>" + this.degree + "</degree>" + "<school_type>" + this.school_type + "</school_type>";
    }
}