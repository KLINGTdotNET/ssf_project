package com.facebook.api;


class NotesDeleteResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<notes_delete_response>" + this.value + "</notes_delete_response>";
    }
}