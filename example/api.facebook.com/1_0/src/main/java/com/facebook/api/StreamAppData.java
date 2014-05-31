package com.facebook.api;


class StreamAppData  {


    private Long tbid;
    private String attachment_data;
    private String images;


    public void setTbid(Long tbid) {
        this.tbid = tbid;
    }

    public Long getTbid() {
        return this.tbid;
    }
    public void setAttachmentData(String attachment_data) {
        this.attachment_data = attachment_data;
    }

    public String getAttachmentData() {
        return this.attachment_data;
    }
    public void setImages(String images) {
        this.images = images;
    }

    public String getImages() {
        return this.images;
    }

    public String toXML() {
        return "<tbid>" + this.tbid + "</tbid>" + "<attachment_data>" + this.attachment_data + "</attachment_data>" + "<images>" + this.images + "</images>";
    }
}