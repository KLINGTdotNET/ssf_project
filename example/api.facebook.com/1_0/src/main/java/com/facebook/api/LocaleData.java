package com.facebook.api;


class LocaleData  {


    private String locale;


    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocale() {
        return this.locale;
    }

    public String toXML() {
        return "<locale>" + this.locale + "</locale>";
    }
}