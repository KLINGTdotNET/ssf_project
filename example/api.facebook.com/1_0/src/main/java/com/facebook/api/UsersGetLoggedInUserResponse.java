/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;

import com.facebook.api.Uid;

class UsersGetLoggedInUserResponse {
    private Uid value;

    public void setValue(Uid value) {
        this.value = value;
    }

    public Uid getValue() {
        return this.value;
    }

    public String toXML() {
        return "<users_getLoggedInUser_response>" + this.value + "</users_getLoggedInUser_response>";
    }
}