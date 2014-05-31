package com.facebook.api;


class InfoField  {


    private String field;


    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;
    }

    public String toXML() {
        return "<field>" + this.field + "</field>";
    }
}