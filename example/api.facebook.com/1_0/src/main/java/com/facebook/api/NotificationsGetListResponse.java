package com.facebook.api;

import com.facebook.api.NotificationData;

class NotificationsGetListResponse {
    private NotificationData value;

    public void setValue(NotificationData value) {
        this.value = value;
    }

    public NotificationData getValue() {
        return this.value;
    }

    public String toXML() {
        return "<notifications_getList_response>" + this.value + "</notifications_getList_response>";
    }
}