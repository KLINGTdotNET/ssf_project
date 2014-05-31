package com.facebook.api;


class FqlResult  {


    private String name;
    private String fql_result_set;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setFqlResultSet(String fql_result_set) {
        this.fql_result_set = fql_result_set;
    }

    public String getFqlResultSet() {
        return this.fql_result_set;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<fql_result_set>" + this.fql_result_set + "</fql_result_set>";
    }
}