/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;


class EventsRsvpResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<events_rsvp_response>" + this.value + "</events_rsvp_response>";
    }
}