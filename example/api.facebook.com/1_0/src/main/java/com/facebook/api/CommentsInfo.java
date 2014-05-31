package com.facebook.api;

import com.facebook.api.Xid;
import com.facebook.api.Time;

class CommentsInfo  {


    private Long app_id;
    private Xid xid;
    private Time updated_time;
    private Integer count;


    public void setAppId(Long app_id) {
        this.app_id = app_id;
    }

    public Long getAppId() {
        return this.app_id;
    }
    public void setXid(Xid xid) {
        this.xid = xid;
    }

    public Xid getXid() {
        return this.xid;
    }
    public void setUpdatedTime(Time updated_time) {
        this.updated_time = updated_time;
    }

    public Time getUpdatedTime() {
        return this.updated_time;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return this.count;
    }

    public String toXML() {
        return "<app_id>" + this.app_id + "</app_id>" + this.xid.toXML() + this.updated_time.toXML() + "<count>" + this.count + "</count>";
    }
}