/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;

import com.facebook.api.Fbid;

class DashboardAddGlobalNewsResponse {
    private Fbid value;

    public void setValue(Fbid value) {
        this.value = value;
    }

    public Fbid getValue() {
        return this.value;
    }

    public String toXML() {
        return "<dashboard_addGlobalNews_response>" + this.value + "</dashboard_addGlobalNews_response>";
    }
}