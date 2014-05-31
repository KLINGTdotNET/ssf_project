package com.facebook.api;

import com.facebook.api.StreamComments;
import com.facebook.api.StreamLikes;
import com.facebook.api.Pid;

class PhotoFeedback  {


    private Pid pid;
    private StreamComments comments;
    private StreamLikes likes;


    public void setPid(Pid pid) {
        this.pid = pid;
    }

    public Pid getPid() {
        return this.pid;
    }
    public void setComments(StreamComments comments) {
        this.comments = comments;
    }

    public StreamComments getComments() {
        return this.comments;
    }
    public void setLikes(StreamLikes likes) {
        this.likes = likes;
    }

    public StreamLikes getLikes() {
        return this.likes;
    }

    public String toXML() {
        return this.pid.toXML() + this.comments.toXML() + this.likes.toXML();
    }
}