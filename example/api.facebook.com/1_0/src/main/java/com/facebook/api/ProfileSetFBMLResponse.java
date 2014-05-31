package com.facebook.api;


class ProfileSetFBMLResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<profile_setFBML_response>" + this.value + "</profile_setFBML_response>";
    }
}