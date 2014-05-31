package com.facebook.api;

import com.facebook.api.Uid;

class MailboxFolder  {


    private Integer folder_id;
    private String name;
    private Integer unread_count;
    private Integer total_count;
    private Uid viewer_id;


    public void setFolderId(Integer folder_id) {
        this.folder_id = folder_id;
    }

    public Integer getFolderId() {
        return this.folder_id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setUnreadCount(Integer unread_count) {
        this.unread_count = unread_count;
    }

    public Integer getUnreadCount() {
        return this.unread_count;
    }
    public void setTotalCount(Integer total_count) {
        this.total_count = total_count;
    }

    public Integer getTotalCount() {
        return this.total_count;
    }
    public void setViewerId(Uid viewer_id) {
        this.viewer_id = viewer_id;
    }

    public Uid getViewerId() {
        return this.viewer_id;
    }

    public String toXML() {
        return "<folder_id>" + this.folder_id + "</folder_id>" + "<name>" + this.name + "</name>" + "<unread_count>" + this.unread_count + "</unread_count>" + "<total_count>" + this.total_count + "</total_count>" + this.viewer_id.toXML();
    }
}