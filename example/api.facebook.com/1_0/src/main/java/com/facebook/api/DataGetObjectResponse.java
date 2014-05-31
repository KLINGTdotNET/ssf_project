package com.facebook.api;

import com.facebook.api.Container;

class DataGetObjectResponse {
    private Container value;

    public void setValue(Container value) {
        this.value = value;
    }

    public Container getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_getObject_response>" + this.value + "</data_getObject_response>";
    }
}