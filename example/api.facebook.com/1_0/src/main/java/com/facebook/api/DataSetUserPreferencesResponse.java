package com.facebook.api;


class DataSetUserPreferencesResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_setUserPreferences_response>" + this.value + "</data_setUserPreferences_response>";
    }
}