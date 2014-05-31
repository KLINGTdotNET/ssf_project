package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Time;
import com.facebook.api.StatusId;

class UserStatus  {


    private String message;
    private Time time;
    private StatusId status_id;
    private String source;
    private Uid uid;
    private Integer comment_count;


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return this.time;
    }
    public void setStatusId(StatusId status_id) {
        this.status_id = status_id;
    }

    public StatusId getStatusId() {
        return this.status_id;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }
    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setCommentCount(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getCommentCount() {
        return this.comment_count;
    }

    public String toXML() {
        return "<message>" + this.message + "</message>" + this.time.toXML() + this.status_id.toXML() + "<source>" + this.source + "</source>" + this.uid.toXML() + "<comment_count>" + this.comment_count + "</comment_count>";
    }
}