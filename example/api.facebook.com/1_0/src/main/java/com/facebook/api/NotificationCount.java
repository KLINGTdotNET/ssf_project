package com.facebook.api;

import com.facebook.api.Time;

class NotificationCount  {


    private Integer unread;
    private Time most_recent;


    public void setUnread(Integer unread) {
        this.unread = unread;
    }

    public Integer getUnread() {
        return this.unread;
    }
    public void setMostRecent(Time most_recent) {
        this.most_recent = most_recent;
    }

    public Time getMostRecent() {
        return this.most_recent;
    }

    public String toXML() {
        return "<unread>" + this.unread + "</unread>" + this.most_recent.toXML();
    }
}