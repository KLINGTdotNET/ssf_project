package com.facebook.api;

import com.facebook.api.Xid;
import com.facebook.api.CommentId;
import com.facebook.api.Time;
import com.facebook.api.Uid;

class Comment  {


    private Xid xid;
    private Uid fromid;
    private Time time;
    private String text;
    private CommentId id;
    private String username;
    private Xid reply_xid;
    private String post_id;
    private Long app_id;
    private Integer likes;


    public void setXid(Xid xid) {
        this.xid = xid;
    }

    public Xid getXid() {
        return this.xid;
    }
    public void setFromid(Uid fromid) {
        this.fromid = fromid;
    }

    public Uid getFromid() {
        return this.fromid;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return this.time;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    public void setId(CommentId id) {
        this.id = id;
    }

    public CommentId getId() {
        return this.id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
    public void setReplyXid(Xid reply_xid) {
        this.reply_xid = reply_xid;
    }

    public Xid getReplyXid() {
        return this.reply_xid;
    }
    public void setPostId(String post_id) {
        this.post_id = post_id;
    }

    public String getPostId() {
        return this.post_id;
    }
    public void setAppId(Long app_id) {
        this.app_id = app_id;
    }

    public Long getAppId() {
        return this.app_id;
    }
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getLikes() {
        return this.likes;
    }

    public String toXML() {
        return this.xid.toXML() + this.fromid.toXML() + this.time.toXML() + "<text>" + this.text + "</text>" + this.id.toXML() + "<username>" + this.username + "</username>" + this.reply_xid.toXML() + "<post_id>" + this.post_id + "</post_id>" + "<app_id>" + this.app_id + "</app_id>" + "<likes>" + this.likes + "</likes>";
    }
}