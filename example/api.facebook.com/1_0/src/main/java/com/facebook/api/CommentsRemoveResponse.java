package com.facebook.api;


class CommentsRemoveResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<comments_remove_response>" + this.value + "</comments_remove_response>";
    }
}