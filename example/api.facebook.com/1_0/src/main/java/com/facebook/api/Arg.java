/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;


class Arg  {


    private String key;
    private String value;


    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toXML() {
        return "<key>" + this.key + "</key>" + "<value>" + this.value + "</value>";
    }
}