package com.facebook.api;

import com.facebook.api.Uid;

class FamilyInfo  {


    private String relationship;
    private Uid uid;
    private String name;
    private String birthday;
    private Uid profile_id;


    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return this.relationship;
    }
    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public Uid getUid() {
        return this.uid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return this.birthday;
    }
    public void setProfileId(Uid profile_id) {
        this.profile_id = profile_id;
    }

    public Uid getProfileId() {
        return this.profile_id;
    }

    public String toXML() {
        return "<relationship>" + this.relationship + "</relationship>" + this.uid.toXML() + "<name>" + this.name + "</name>" + "<birthday>" + this.birthday + "</birthday>" + this.profile_id.toXML();
    }
}