package com.facebook.api;


class StreamComments  {


    private Boolean can_remove;
    private Boolean can_post;
    private Integer count;


    public void setCanRemove(Boolean can_remove) {
        this.can_remove = can_remove;
    }

    public Boolean getCanRemove() {
        return this.can_remove;
    }
    public void setCanPost(Boolean can_post) {
        this.can_post = can_post;
    }

    public Boolean getCanPost() {
        return this.can_post;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return this.count;
    }

    public String toXML() {
        return "<can_remove>" + this.can_remove + "</can_remove>" + "<can_post>" + this.can_post + "</can_post>" + "<count>" + this.count + "</count>";
    }
}