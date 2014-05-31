package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Id;
import com.facebook.api.Time;

class Notification  {


    private Id notification_id;
    private Uid sender_id;
    private Uid recipient_id;
    private Time created_time;
    private Time updated_time;
    private String title_html;
    private String title_text;
    private String body_html;
    private String body_text;
    private String href;
    private Id app_id;
    private Integer is_unread;
    private Integer is_hidden;
    private String object_id;
    private String object_type;


    public void setNotificationId(Id notification_id) {
        this.notification_id = notification_id;
    }

    public Id getNotificationId() {
        return this.notification_id;
    }
    public void setSenderId(Uid sender_id) {
        this.sender_id = sender_id;
    }

    public Uid getSenderId() {
        return this.sender_id;
    }
    public void setRecipientId(Uid recipient_id) {
        this.recipient_id = recipient_id;
    }

    public Uid getRecipientId() {
        return this.recipient_id;
    }
    public void setCreatedTime(Time created_time) {
        this.created_time = created_time;
    }

    public Time getCreatedTime() {
        return this.created_time;
    }
    public void setUpdatedTime(Time updated_time) {
        this.updated_time = updated_time;
    }

    public Time getUpdatedTime() {
        return this.updated_time;
    }
    public void setTitleHtml(String title_html) {
        this.title_html = title_html;
    }

    public String getTitleHtml() {
        return this.title_html;
    }
    public void setTitleText(String title_text) {
        this.title_text = title_text;
    }

    public String getTitleText() {
        return this.title_text;
    }
    public void setBodyHtml(String body_html) {
        this.body_html = body_html;
    }

    public String getBodyHtml() {
        return this.body_html;
    }
    public void setBodyText(String body_text) {
        this.body_text = body_text;
    }

    public String getBodyText() {
        return this.body_text;
    }
    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return this.href;
    }
    public void setAppId(Id app_id) {
        this.app_id = app_id;
    }

    public Id getAppId() {
        return this.app_id;
    }
    public void setIsUnread(Integer is_unread) {
        this.is_unread = is_unread;
    }

    public Integer getIsUnread() {
        return this.is_unread;
    }
    public void setIsHidden(Integer is_hidden) {
        this.is_hidden = is_hidden;
    }

    public Integer getIsHidden() {
        return this.is_hidden;
    }
    public void setObjectId(String object_id) {
        this.object_id = object_id;
    }

    public String getObjectId() {
        return this.object_id;
    }
    public void setObjectType(String object_type) {
        this.object_type = object_type;
    }

    public String getObjectType() {
        return this.object_type;
    }

    public String toXML() {
        return this.notification_id.toXML() + this.sender_id.toXML() + this.recipient_id.toXML() + this.created_time.toXML() + this.updated_time.toXML() + "<title_html>" + this.title_html + "</title_html>" + "<title_text>" + this.title_text + "</title_text>" + "<body_html>" + this.body_html + "</body_html>" + "<body_text>" + this.body_text + "</body_text>" + "<href>" + this.href + "</href>" + this.app_id.toXML() + "<is_unread>" + this.is_unread + "</is_unread>" + "<is_hidden>" + this.is_hidden + "</is_hidden>" + "<object_id>" + this.object_id + "</object_id>" + "<object_type>" + this.object_type + "</object_type>";
    }
}