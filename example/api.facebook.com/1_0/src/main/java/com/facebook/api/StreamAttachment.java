package com.facebook.api;


class StreamAttachment  {


    private String name;
    private String href;
    private String caption;
    private String description;
    private String icon;
    private String fb_object_type;
    private String fb_object_id;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return this.href;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return this.caption;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return this.icon;
    }
    public void setFbObjectType(String fb_object_type) {
        this.fb_object_type = fb_object_type;
    }

    public String getFbObjectType() {
        return this.fb_object_type;
    }
    public void setFbObjectId(String fb_object_id) {
        this.fb_object_id = fb_object_id;
    }

    public String getFbObjectId() {
        return this.fb_object_id;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<href>" + this.href + "</href>" + "<caption>" + this.caption + "</caption>" + "<description>" + this.description + "</description>" + "<icon>" + this.icon + "</icon>" + "<fb_object_type>" + this.fb_object_type + "</fb_object_type>" + "<fb_object_id>" + this.fb_object_id + "</fb_object_id>";
    }
}