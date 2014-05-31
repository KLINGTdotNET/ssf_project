package com.facebook.api;

import com.facebook.api.LinkId;

class LinksPostResponse {
    private LinkId value;

    public void setValue(LinkId value) {
        this.value = value;
    }

    public LinkId getValue() {
        return this.value;
    }

    public String toXML() {
        return "<links_post_response>" + this.value + "</links_post_response>";
    }
}