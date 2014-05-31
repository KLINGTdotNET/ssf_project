package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Gid;
import com.facebook.api.Time;
import com.facebook.api.Location;
import com.facebook.api.Nid;

class Group  {


    private Gid gid;
    private String name;
    private Nid nid;
    private String description;
    private String group_type;
    private String group_subtype;
    private String recent_news;
    private String pic;
    private String pic_big;
    private String pic_small;
    private Uid creator;
    private Time update_time;
    private String office;
    private String website;
    private Location venue;
    private String privacy;


    public void setGid(Gid gid) {
        this.gid = gid;
    }

    public Gid getGid() {
        return this.gid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setNid(Nid nid) {
        this.nid = nid;
    }

    public Nid getNid() {
        return this.nid;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setGroupType(String group_type) {
        this.group_type = group_type;
    }

    public String getGroupType() {
        return this.group_type;
    }
    public void setGroupSubtype(String group_subtype) {
        this.group_subtype = group_subtype;
    }

    public String getGroupSubtype() {
        return this.group_subtype;
    }
    public void setRecentNews(String recent_news) {
        this.recent_news = recent_news;
    }

    public String getRecentNews() {
        return this.recent_news;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return this.pic;
    }
    public void setPicBig(String pic_big) {
        this.pic_big = pic_big;
    }

    public String getPicBig() {
        return this.pic_big;
    }
    public void setPicSmall(String pic_small) {
        this.pic_small = pic_small;
    }

    public String getPicSmall() {
        return this.pic_small;
    }
    public void setCreator(Uid creator) {
        this.creator = creator;
    }

    public Uid getCreator() {
        return this.creator;
    }
    public void setUpdateTime(Time update_time) {
        this.update_time = update_time;
    }

    public Time getUpdateTime() {
        return this.update_time;
    }
    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return this.office;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return this.website;
    }
    public void setVenue(Location venue) {
        this.venue = venue;
    }

    public Location getVenue() {
        return this.venue;
    }
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getPrivacy() {
        return this.privacy;
    }

    public String toXML() {
        return this.gid.toXML() + "<name>" + this.name + "</name>" + this.nid.toXML() + "<description>" + this.description + "</description>" + "<group_type>" + this.group_type + "</group_type>" + "<group_subtype>" + this.group_subtype + "</group_subtype>" + "<recent_news>" + this.recent_news + "</recent_news>" + "<pic>" + this.pic + "</pic>" + "<pic_big>" + this.pic_big + "</pic_big>" + "<pic_small>" + this.pic_small + "</pic_small>" + this.creator.toXML() + this.update_time.toXML() + "<office>" + this.office + "</office>" + "<website>" + this.website + "</website>" + this.venue.toXML() + "<privacy>" + this.privacy + "</privacy>";
    }
}