/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;

import com.facebook.api.LinkId;

class LinksPostResponse {
    private LinkId value;

    public void setValue(LinkId value) {
        this.value = value;
    }

    public LinkId getValue() {
        return this.value;
    }

    public String toXML() {
        return "<links_post_response>" + this.value + "</links_post_response>";
    }
}