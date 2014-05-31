package com.facebook.api;

import com.facebook.api.NotificationCount;

class Notifications  {


    private NotificationCount messages;
    private NotificationCount pokes;
    private NotificationCount shares;


    public void setMessages(NotificationCount messages) {
        this.messages = messages;
    }

    public NotificationCount getMessages() {
        return this.messages;
    }
    public void setPokes(NotificationCount pokes) {
        this.pokes = pokes;
    }

    public NotificationCount getPokes() {
        return this.pokes;
    }
    public void setShares(NotificationCount shares) {
        this.shares = shares;
    }

    public NotificationCount getShares() {
        return this.shares;
    }

    public String toXML() {
        return this.messages.toXML() + this.pokes.toXML() + this.shares.toXML();
    }
}