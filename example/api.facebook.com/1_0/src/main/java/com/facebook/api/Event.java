package com.facebook.api;

import com.facebook.api.Eid;
import com.facebook.api.Id;
import com.facebook.api.Time;
import com.facebook.api.Location;
import com.facebook.api.Nid;

class Event  {


    private Eid eid;
    private String name;
    private String tagline;
    private Nid nid;
    private String pic;
    private String pic_big;
    private String pic_small;
    private String host;
    private String description;
    private String event_type;
    private String event_subtype;
    private Time start_time;
    private Time end_time;
    private Id creator;
    private Time update_time;
    private String location;
    private Location venue;
    private String privacy;
    private Boolean hide_guest_list;
    private Boolean show_in_search;
    private Boolean show_wall;
    private Boolean show_videos;
    private Boolean show_photos;
    private Boolean show_posts;


    public void setEid(Eid eid) {
        this.eid = eid;
    }

    public Eid getEid() {
        return this.eid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTagline() {
        return this.tagline;
    }
    public void setNid(Nid nid) {
        this.nid = nid;
    }

    public Nid getNid() {
        return this.nid;
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
    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return this.host;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setEventType(String event_type) {
        this.event_type = event_type;
    }

    public String getEventType() {
        return this.event_type;
    }
    public void setEventSubtype(String event_subtype) {
        this.event_subtype = event_subtype;
    }

    public String getEventSubtype() {
        return this.event_subtype;
    }
    public void setStartTime(Time start_time) {
        this.start_time = start_time;
    }

    public Time getStartTime() {
        return this.start_time;
    }
    public void setEndTime(Time end_time) {
        this.end_time = end_time;
    }

    public Time getEndTime() {
        return this.end_time;
    }
    public void setCreator(Id creator) {
        this.creator = creator;
    }

    public Id getCreator() {
        return this.creator;
    }
    public void setUpdateTime(Time update_time) {
        this.update_time = update_time;
    }

    public Time getUpdateTime() {
        return this.update_time;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
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
    public void setHideGuestList(Boolean hide_guest_list) {
        this.hide_guest_list = hide_guest_list;
    }

    public Boolean getHideGuestList() {
        return this.hide_guest_list;
    }
    public void setShowInSearch(Boolean show_in_search) {
        this.show_in_search = show_in_search;
    }

    public Boolean getShowInSearch() {
        return this.show_in_search;
    }
    public void setShowWall(Boolean show_wall) {
        this.show_wall = show_wall;
    }

    public Boolean getShowWall() {
        return this.show_wall;
    }
    public void setShowVideos(Boolean show_videos) {
        this.show_videos = show_videos;
    }

    public Boolean getShowVideos() {
        return this.show_videos;
    }
    public void setShowPhotos(Boolean show_photos) {
        this.show_photos = show_photos;
    }

    public Boolean getShowPhotos() {
        return this.show_photos;
    }
    public void setShowPosts(Boolean show_posts) {
        this.show_posts = show_posts;
    }

    public Boolean getShowPosts() {
        return this.show_posts;
    }

    public String toXML() {
        return this.eid.toXML() + "<name>" + this.name + "</name>" + "<tagline>" + this.tagline + "</tagline>" + this.nid.toXML() + "<pic>" + this.pic + "</pic>" + "<pic_big>" + this.pic_big + "</pic_big>" + "<pic_small>" + this.pic_small + "</pic_small>" + "<host>" + this.host + "</host>" + "<description>" + this.description + "</description>" + "<event_type>" + this.event_type + "</event_type>" + "<event_subtype>" + this.event_subtype + "</event_subtype>" + this.start_time.toXML() + this.end_time.toXML() + this.creator.toXML() + this.update_time.toXML() + "<location>" + this.location + "</location>" + this.venue.toXML() + "<privacy>" + this.privacy + "</privacy>" + "<hide_guest_list>" + this.hide_guest_list + "</hide_guest_list>" + "<show_in_search>" + this.show_in_search + "</show_in_search>" + "<show_wall>" + this.show_wall + "</show_wall>" + "<show_videos>" + this.show_videos + "</show_videos>" + "<show_photos>" + this.show_photos + "</show_photos>" + "<show_posts>" + this.show_posts + "</show_posts>";
    }
}