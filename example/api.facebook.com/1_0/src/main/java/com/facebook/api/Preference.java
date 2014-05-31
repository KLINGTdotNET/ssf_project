package com.facebook.api;


class Preference  {


    private Integer pref_id;
    private String value;


    public void setPrefId(Integer pref_id) {
        this.pref_id = pref_id;
    }

    public Integer getPrefId() {
        return this.pref_id;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<pref_id>" + this.pref_id + "</pref_id>" + "<value>" + this.value + "</value>";
    }
}