package com.facebook.api;

import com.facebook.api.ObjectAssocInfo;

class DataGetAssociationDefinitionResponse {
    private ObjectAssocInfo value;

    public void setValue(ObjectAssocInfo value) {
        this.value = value;
    }

    public ObjectAssocInfo getValue() {
        return this.value;
    }

    public String toXML() {
        return "<data_getAssociationDefinition_response>" + this.value + "</data_getAssociationDefinition_response>";
    }
}