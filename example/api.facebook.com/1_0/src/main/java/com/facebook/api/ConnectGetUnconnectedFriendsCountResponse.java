package com.facebook.api;


class ConnectGetUnconnectedFriendsCountResponse {
    private Integer value;

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toXML() {
        return "<connect_getUnconnectedFriendsCount_response>" + this.value + "</connect_getUnconnectedFriendsCount_response>";
    }
}