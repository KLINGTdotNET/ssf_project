package com.facebook.api;


class StreamProperty  {


    private String name;
    private String text;
    private String href;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return this.href;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<text>" + this.text + "</text>" + "<href>" + this.href + "</href>";
    }
}