package com.facebook.api;


class ObjectPropertyInfo  {


    private String name;
    private Integer data_type;
    private Integer index_type;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setDataType(Integer data_type) {
        this.data_type = data_type;
    }

    public Integer getDataType() {
        return this.data_type;
    }
    public void setIndexType(Integer index_type) {
        this.index_type = index_type;
    }

    public Integer getIndexType() {
        return this.index_type;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<data_type>" + this.data_type + "</data_type>" + "<index_type>" + this.index_type + "</index_type>";
    }
}