package com.facebook.api;


class DataSetUserPreferenceResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_setUserPreference_response>" + this.value + "</data_setUserPreference_response>";
    }
}