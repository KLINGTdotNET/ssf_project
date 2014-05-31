package com.facebook.api;

import com.facebook.api.NoteId;

class NotesCreateResponse {
    private NoteId value;

    public void setValue(NoteId value) {
        this.value = value;
    }

    public NoteId getValue() {
        return this.value;
    }

    public String toXML() {
        return "<notes_create_response>" + this.value + "</notes_create_response>";
    }
}