package com.facebook.api;


class VideoLimits  {


    private Integer length;
    private Long size;


    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLength() {
        return this.length;
    }
    public void setSize(Long size) {
        this.size = size;
    }

    public Long getSize() {
        return this.size;
    }

    public String toXML() {
        return "<length>" + this.length + "</length>" + "<size>" + this.size + "</size>";
    }
}