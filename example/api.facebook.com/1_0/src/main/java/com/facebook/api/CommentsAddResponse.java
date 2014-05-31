package com.facebook.api;

import com.facebook.api.CommentId;

class CommentsAddResponse {
    private CommentId value;

    public void setValue(CommentId value) {
        this.value = value;
    }

    public CommentId getValue() {
        return this.value;
    }

    public String toXML() {
        return "<comments_add_response>" + this.value + "</comments_add_response>";
    }
}