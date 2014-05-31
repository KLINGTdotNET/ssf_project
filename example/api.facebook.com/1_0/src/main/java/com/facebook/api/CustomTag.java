package com.facebook.api;


class CustomTag  {


    private String name;
    private Integer type;
    private String summary;
    private String description;
    private String body;
    private String open_tag;
    private String close_tag;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return this.summary;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }
    public void setOpenTag(String open_tag) {
        this.open_tag = open_tag;
    }

    public String getOpenTag() {
        return this.open_tag;
    }
    public void setCloseTag(String close_tag) {
        this.close_tag = close_tag;
    }

    public String getCloseTag() {
        return this.close_tag;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<type>" + this.type + "</type>" + "<summary>" + this.summary + "</summary>" + "<description>" + this.description + "</description>" + "<body>" + this.body + "</body>" + "<open_tag>" + this.open_tag + "</open_tag>" + "<close_tag>" + this.close_tag + "</close_tag>";
    }
}