/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;

import com.facebook.api.ActionLink;

class DashboardBundle  {


    private String message;
    private ActionLink action_link;


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    public void setActionLink(ActionLink action_link) {
        this.action_link = action_link;
    }

    public ActionLink getActionLink() {
        return this.action_link;
    }

    public String toXML() {
        return "<message>" + this.message + "</message>" + this.action_link.toXML();
    }
}