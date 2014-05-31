package com.facebook.api;


class NotesEditResponse {
    private Boolean value;

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toXML() {
        return "<notes_edit_response>" + this.value + "</notes_edit_response>";
    }
}