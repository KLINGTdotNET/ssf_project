package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.PageId;

class PageAdmin  {


    private PageId page_id;
    private Uid uid;
    private String type;


    public void setPageId(PageId page_id) {
        this.page_id = page_id;
    }

    public PageId getPageId() {
        return this.page_id;
    }
    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String toXML() {
        return this.page_id.toXML() + this.uid.toXML() + "<type>" + this.type + "</type>";
    }
}