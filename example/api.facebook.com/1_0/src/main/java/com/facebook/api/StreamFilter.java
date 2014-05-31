package com.facebook.api;

import com.facebook.api.Uid;

class StreamFilter  {


    private Uid uid;
    private String filter_key;
    private String name;
    private Integer rank;
    private String icon_url;
    private Boolean is_visible;
    private String type;
    private Long value;


    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setFilterKey(String filter_key) {
        this.filter_key = filter_key;
    }

    public String getFilterKey() {
        return this.filter_key;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return this.rank;
    }
    public void setIconUrl(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getIconUrl() {
        return this.icon_url;
    }
    public void setIsVisible(Boolean is_visible) {
        this.is_visible = is_visible;
    }

    public Boolean getIsVisible() {
        return this.is_visible;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
    public void setValue(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return this.value;
    }

    public String toXML() {
        return this.uid.toXML() + "<filter_key>" + this.filter_key + "</filter_key>" + "<name>" + this.name + "</name>" + "<rank>" + this.rank + "</rank>" + "<icon_url>" + this.icon_url + "</icon_url>" + "<is_visible>" + this.is_visible + "</is_visible>" + "<type>" + this.type + "</type>" + "<value>" + this.value + "</value>";
    }
}