package com.facebook.api;

import com.facebook.api.Notifications;

class NotificationsGetResponse {
    private Notifications value;

    public void setValue(Notifications value) {
        this.value = value;
    }

    public Notifications getValue() {
        return this.value;
    }

    public String toXML() {
        return "<notifications_get_response>" + this.value + "</notifications_get_response>";
    }
}