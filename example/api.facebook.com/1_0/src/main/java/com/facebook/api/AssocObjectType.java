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