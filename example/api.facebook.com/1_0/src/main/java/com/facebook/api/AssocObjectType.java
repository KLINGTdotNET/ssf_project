/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;


class AssocObjectType  {


    private String alias;
    private String object_type;
    private Boolean unique;


    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return this.alias;
    }
    public void setObjectType(String object_type) {
        this.object_type = object_type;
    }

    public String getObjectType() {
        return this.object_type;
    }
    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Boolean getUnique() {
        return this.unique;
    }

    public String toXML() {
        return "<alias>" + this.alias + "</alias>" + "<object_type>" + this.object_type + "</object_type>" + "<unique>" + this.unique + "</unique>";
    }
}