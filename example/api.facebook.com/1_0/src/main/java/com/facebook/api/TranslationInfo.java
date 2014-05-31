package com.facebook.api;


class TranslationInfo  {


    private String translation;
    private String status;
    private String description;


    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return this.translation;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String toXML() {
        return "<translation>" + this.translation + "</translation>" + "<status>" + this.status + "</status>" + "<description>" + this.description + "</description>";
    }
}