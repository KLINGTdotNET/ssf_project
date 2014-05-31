package com.facebook.api;


class StreamSwf  {


    private String source_url;
    private String preview_img;
    private String flash_vars;
    private Integer width;
    private Integer height;


    public void setSourceUrl(String source_url) {
        this.source_url = source_url;
    }

    public String getSourceUrl() {
        return this.source_url;
    }
    public void setPreviewImg(String preview_img) {
        this.preview_img = preview_img;
    }

    public String getPreviewImg() {
        return this.preview_img;
    }
    public void setFlashVars(String flash_vars) {
        this.flash_vars = flash_vars;
    }

    public String getFlashVars() {
        return this.flash_vars;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return this.width;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return this.height;
    }

    public String toXML() {
        return "<source_url>" + this.source_url + "</source_url>" + "<preview_img>" + this.preview_img + "</preview_img>" + "<flash_vars>" + this.flash_vars + "</flash_vars>" + "<width>" + this.width + "</width>" + "<height>" + this.height + "</height>";
    }
}