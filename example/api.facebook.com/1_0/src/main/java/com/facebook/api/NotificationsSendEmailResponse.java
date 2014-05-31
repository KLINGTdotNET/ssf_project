package com.facebook.api;

import com.facebook.api.UidList;

class NotificationsSendEmailResponse {
    private UidList value;

    public void setValue(UidList value) {
        this.value = value;
    }

    public UidList getValue() {
        return this.value;
    }

    public String toXML() {
        return "<notifications_sendEmail_response>" + this.value + "</notifications_sendEmail_response>";
    }
}