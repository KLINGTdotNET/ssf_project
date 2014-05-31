package com.facebook.api;


class LinkStat  {


    private String url;
    private Long share_count;
    private Long like_count;
    private Long comment_count;
    private Long total_count;
    private Long click_count;
    private String normalized_url;


    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
    public void setShareCount(Long share_count) {
        this.share_count = share_count;
    }

    public Long getShareCount() {
        return this.share_count;
    }
    public void setLikeCount(Long like_count) {
        this.like_count = like_count;
    }

    public Long getLikeCount() {
        return this.like_count;
    }
    public void setCommentCount(Long comment_count) {
        this.comment_count = comment_count;
    }

    public Long getCommentCount() {
        return this.comment_count;
    }
    public void setTotalCount(Long total_count) {
        this.total_count = total_count;
    }

    public Long getTotalCount() {
        return this.total_count;
    }
    public void setClickCount(Long click_count) {
        this.click_count = click_count;
    }

    public Long getClickCount() {
        return this.click_count;
    }
    public void setNormalizedUrl(String normalized_url) {
        this.normalized_url = normalized_url;
    }

    public String getNormalizedUrl() {
        return this.normalized_url;
    }

    public String toXML() {
        return "<url>" + this.url + "</url>" + "<share_count>" + this.share_count + "</share_count>" + "<like_count>" + this.like_count + "</like_count>" + "<comment_count>" + this.comment_count + "</comment_count>" + "<total_count>" + this.total_count + "</total_count>" + "<click_count>" + this.click_count + "</click_count>" + "<normalized_url>" + this.normalized_url + "</normalized_url>";
    }
}