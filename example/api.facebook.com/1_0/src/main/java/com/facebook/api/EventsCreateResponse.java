/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;

import com.facebook.api.Eid;

class EventsCreateResponse {
    private Eid value;

    public void setValue(Eid value) {
        this.value = value;
    }

    public Eid getValue() {
        return this.value;
    }

    public String toXML() {
        return "<events_create_response>" + this.value + "</events_create_response>";
    }
}