package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Time;
import com.facebook.api.PostId;

class FeedStory  {


    private Uid actor_id;
    private PostId post_id;
    private String story_title;
    private String story_body;
    private String images;
    private String flash;
    private String mp3;
    private String video;
    private Time time_published;


    public void setActorId(Uid actor_id) {
        this.actor_id = actor_id;
    }

    public Uid getActorId() {
        return this.actor_id;
    }
    public void setPostId(PostId post_id) {
        this.post_id = post_id;
    }

    public PostId getPostId() {
        return this.post_id;
    }
    public void setStoryTitle(String story_title) {
        this.story_title = story_title;
    }

    public String getStoryTitle() {
        return this.story_title;
    }
    public void setStoryBody(String story_body) {
        this.story_body = story_body;
    }

    public String getStoryBody() {
        return this.story_body;
    }
    public void setImages(String images) {
        this.images = images;
    }

    public String getImages() {
        return this.images;
    }
    public void setFlash(String flash) {
        this.flash = flash;
    }

    public String getFlash() {
        return this.flash;
    }
    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getMp3() {
        return this.mp3;
    }
    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideo() {
        return this.video;
    }
    public void setTimePublished(Time time_published) {
        this.time_published = time_published;
    }

    public Time getTimePublished() {
        return this.time_published;
    }

    public String toXML() {
        return this.actor_id.toXML() + this.post_id.toXML() + "<story_title>" + this.story_title + "</story_title>" + "<story_body>" + this.story_body + "</story_body>" + "<images>" + this.images + "</images>" + "<flash>" + this.flash + "</flash>" + "<mp3>" + this.mp3 + "</mp3>" + "<video>" + this.video + "</video>" + this.time_published.toXML();
    }
}