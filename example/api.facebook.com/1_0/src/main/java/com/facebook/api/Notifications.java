/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

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