package com.facebook.api;


class ProfileGetFBMLResponse {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<profile_getFBML_response>" + this.value + "</profile_getFBML_response>";
    }
}