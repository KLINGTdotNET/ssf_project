/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;


class Connection  {


    private Long source_id;
    private Long target_id;
    private Boolean is_following;


    public void setSourceId(Long source_id) {
        this.source_id = source_id;
    }

    public Long getSourceId() {
        return this.source_id;
    }
    public void setTargetId(Long target_id) {
        this.target_id = target_id;
    }

    public Long getTargetId() {
        return this.target_id;
    }
    public void setIsFollowing(Boolean is_following) {
        this.is_following = is_following;
    }

    public Boolean getIsFollowing() {
        return this.is_following;
    }

    public String toXML() {
        return "<source_id>" + this.source_id + "</source_id>" + "<target_id>" + this.target_id + "</target_id>" + "<is_following>" + this.is_following + "</is_following>";
    }
}