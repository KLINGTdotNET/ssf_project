package com.facebook.api;

import com.facebook.api.Time;
import com.facebook.api.NoteId;

class Note  {


    private NoteId note_id;
    private String title;
    private String content;
    private Time created_time;
    private Time updated_time;


    public void setNoteId(NoteId note_id) {
        this.note_id = note_id;
    }

    public NoteId getNoteId() {
        return this.note_id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
    public void setCreatedTime(Time created_time) {
        this.created_time = created_time;
    }

    public Time getCreatedTime() {
        return this.created_time;
    }
    public void setUpdatedTime(Time updated_time) {
        this.updated_time = updated_time;
    }

    public Time getUpdatedTime() {
        return this.updated_time;
    }

    public String toXML() {
        return this.note_id.toXML() + "<title>" + this.title + "</title>" + "<content>" + this.content + "</content>" + this.created_time.toXML() + this.updated_time.toXML();
    }
}