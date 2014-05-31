package com.facebook.api;


class Phrase  {


    private String description;
    private String text;


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String toXML() {
        return "<description>" + this.description + "</description>" + "<text>" + this.text + "</text>";
    }
}