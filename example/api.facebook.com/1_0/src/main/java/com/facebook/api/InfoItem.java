package com.facebook.api;


class InfoItem  {


    private String label;
    private String sublabel;
    private String description;
    private String link;
    private String image;
    private String meta;


    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
    public void setSublabel(String sublabel) {
        this.sublabel = sublabel;
    }

    public String getSublabel() {
        return this.sublabel;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }
    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getMeta() {
        return this.meta;
    }

    public String toXML() {
        return "<label>" + this.label + "</label>" + "<sublabel>" + this.sublabel + "</sublabel>" + "<description>" + this.description + "</description>" + "<link>" + this.link + "</link>" + "<image>" + this.image + "</image>" + "<meta>" + this.meta + "</meta>";
    }
}