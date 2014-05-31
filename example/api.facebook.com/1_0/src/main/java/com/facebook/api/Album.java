package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Pid;
import com.facebook.api.Aid;
import com.facebook.api.Time;

class Album  {


    private Aid aid;
    private Pid cover_pid;
    private Uid owner;
    private String name;
    private Time created;
    private Time modified;
    private String description;
    private String location;
    private String link;
    private Integer size;
    private String visible;
    private Time modified_major;
    private String type;
    private Long object_id;


    public void setAid(Aid aid) {
        this.aid = aid;
    }

    public Aid getAid() {
        return this.aid;
    }
    public void setCoverPid(Pid cover_pid) {
        this.cover_pid = cover_pid;
    }

    public Pid getCoverPid() {
        return this.cover_pid;
    }
    public void setOwner(Uid owner) {
        this.owner = owner;
    }

    public Uid getOwner() {
        return this.owner;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setCreated(Time created) {
        this.created = created;
    }

    public Time getCreated() {
        return this.created;
    }
    public void setModified(Time modified) {
        this.modified = modified;
    }

    public Time getModified() {
        return this.modified;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return this.size;
    }
    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getVisible() {
        return this.visible;
    }
    public void setModifiedMajor(Time modified_major) {
        this.modified_major = modified_major;
    }

    public Time getModifiedMajor() {
        return this.modified_major;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
    public void setObjectId(Long object_id) {
        this.object_id = object_id;
    }

    public Long getObjectId() {
        return this.object_id;
    }

    public String toXML() {
        return this.aid.toXML() + this.cover_pid.toXML() + this.owner.toXML() + "<name>" + this.name + "</name>" + this.created.toXML() + this.modified.toXML() + "<description>" + this.description + "</description>" + "<location>" + this.location + "</location>" + "<link>" + this.link + "</link>" + "<size>" + this.size + "</size>" + "<visible>" + this.visible + "</visible>" + this.modified_major.toXML() + "<type>" + this.type + "</type>" + "<object_id>" + this.object_id + "</object_id>";
    }
}