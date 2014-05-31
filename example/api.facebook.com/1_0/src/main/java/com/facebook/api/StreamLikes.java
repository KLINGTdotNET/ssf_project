package com.facebook.api;


class StreamLikes  {


    private String href;
    private Integer count;
    private Boolean user_likes;
    private Boolean can_like;


    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return this.href;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return this.count;
    }
    public void setUserLikes(Boolean user_likes) {
        this.user_likes = user_likes;
    }

    public Boolean getUserLikes() {
        return this.user_likes;
    }
    public void setCanLike(Boolean can_like) {
        this.can_like = can_like;
    }

    public Boolean getCanLike() {
        return this.can_like;
    }

    public String toXML() {
        return "<href>" + this.href + "</href>" + "<count>" + this.count + "</count>" + "<user_likes>" + this.user_likes + "</user_likes>" + "<can_like>" + this.can_like + "</can_like>";
    }
}