package com.facebook.api;


class ConnectAccountInfo  {


    private String email_hash;
    private String account_id;
    private String account_url;


    public void setEmailHash(String email_hash) {
        this.email_hash = email_hash;
    }

    public String getEmailHash() {
        return this.email_hash;
    }
    public void setAccountId(String account_id) {
        this.account_id = account_id;
    }

    public String getAccountId() {
        return this.account_id;
    }
    public void setAccountUrl(String account_url) {
        this.account_url = account_url;
    }

    public String getAccountUrl() {
        return this.account_url;
    }

    public String toXML() {
        return "<email_hash>" + this.email_hash + "</email_hash>" + "<account_id>" + this.account_id + "</account_id>" + "<account_url>" + this.account_url + "</account_url>";
    }
}