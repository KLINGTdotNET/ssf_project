package com.facebook.api;


class FbmlRefreshRefUrlResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<fbml_refreshRefUrl_response>" + this.value + "</fbml_refreshRefUrl_response>";
    }
}