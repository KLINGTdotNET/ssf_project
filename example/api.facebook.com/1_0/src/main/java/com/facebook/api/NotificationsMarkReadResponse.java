package com.facebook.api;


class NotificationsMarkReadResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<notifications_markRead_response>" + this.value + "</notifications_markRead_response>";
    }
}