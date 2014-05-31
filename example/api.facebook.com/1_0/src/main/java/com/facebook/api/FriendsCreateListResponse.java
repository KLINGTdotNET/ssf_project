package com.facebook.api;

import com.facebook.api.Friendlist;

class FriendsCreateListResponse {
    private Friendlist value;

    public void setValue(Friendlist value) {
        this.value = value;
    }

    public Friendlist getValue() {
        return this.value;
    }

    public String toXML() {
        return "<friends_createList_response>" + this.value + "</friends_createList_response>";
    }
}