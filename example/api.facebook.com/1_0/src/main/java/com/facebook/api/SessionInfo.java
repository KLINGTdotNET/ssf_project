package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.SessionKey;

class SessionInfo  {


    private SessionKey session_key;
    private Uid uid;
    private Integer expires;
    private String secret;
    private String base_domain;
    private String access_token;


    public void setSessionKey(SessionKey session_key) {
        this.session_key = session_key;
    }

    public SessionKey getSessionKey() {
        return this.session_key;
    }
    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setExpires(Integer expires) {
        this.expires = expires;
    }

    public Integer getExpires() {
        return this.expires;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return this.secret;
    }
    public void setBaseDomain(String base_domain) {
        this.base_domain = base_domain;
    }

    public String getBaseDomain() {
        return this.base_domain;
    }
    public void setAccessToken(String access_token) {
        this.access_token = access_token;
    }

    public String getAccessToken() {
        return this.access_token;
    }

    public String toXML() {
        return this.session_key.toXML() + this.uid.toXML() + "<expires>" + this.expires + "</expires>" + "<secret>" + this.secret + "</secret>" + "<base_domain>" + this.base_domain + "</base_domain>" + "<access_token>" + this.access_token + "</access_token>";
    }
}