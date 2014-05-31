package com.facebook.api;


class StreamActionLink  {


    private String text;
    private String href;


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
        return "<text>" + this.text + "</text>" + "<href>" + this.href + "</href>";
    }
}