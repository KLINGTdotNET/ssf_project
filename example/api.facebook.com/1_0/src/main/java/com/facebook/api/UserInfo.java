package com.facebook.api;


class UserInfo  {


    private String title;
    private Integer type;


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }

    public String toXML() {
        return "<title>" + this.title + "</title>" + "<type>" + this.type + "</type>";
    }
}