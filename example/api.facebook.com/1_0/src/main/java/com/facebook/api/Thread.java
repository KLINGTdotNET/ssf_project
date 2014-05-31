package com.facebook.api;

import com.facebook.api.Uid;
import com.facebook.api.Id;
import com.facebook.api.Time;
import com.facebook.api.MessageId;
import com.facebook.api.ThreadId;

class Thread  {


    private ThreadId thread_id;
    private String subject;
    private Time updated_time;
    private MessageId parent_message_id;
    private ThreadId parent_thread_id;
    private Integer message_count;
    private String snippet;
    private Uid snippet_author;
    private Id object_id;
    private Boolean unread;


    public void setThreadId(ThreadId thread_id) {
        this.thread_id = thread_id;
    }

    public ThreadId getThreadId() {
        return this.thread_id;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }
    public void setUpdatedTime(Time updated_time) {
        this.updated_time = updated_time;
    }

    public Time getUpdatedTime() {
        return this.updated_time;
    }
    public void setParentMessageId(MessageId parent_message_id) {
        this.parent_message_id = parent_message_id;
    }

    public MessageId getParentMessageId() {
        return this.parent_message_id;
    }
    public void setParentThreadId(ThreadId parent_thread_id) {
        this.parent_thread_id = parent_thread_id;
    }

    public ThreadId getParentThreadId() {
        return this.parent_thread_id;
    }
    public void setMessageCount(Integer message_count) {
        this.message_count = message_count;
    }

    public Integer getMessageCount() {
        return this.message_count;
    }
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getSnippet() {
        return this.snippet;
    }
    public void setSnippetAuthor(Uid snippet_author) {
        this.snippet_author = snippet_author;
    }

    public Uid getSnippetAuthor() {
        return this.snippet_author;
    }
    public void setObjectId(Id object_id) {
        this.object_id = object_id;
    }

    public Id getObjectId() {
        return this.object_id;
    }
    public void setUnread(Boolean unread) {
        this.unread = unread;
    }

    public Boolean getUnread() {
        return this.unread;
    }

    public String toXML() {
        return this.thread_id.toXML() + "<subject>" + this.subject + "</subject>" + this.updated_time.toXML() + this.parent_message_id.toXML() + this.parent_thread_id.toXML() + "<message_count>" + this.message_count + "</message_count>" + "<snippet>" + this.snippet + "</snippet>" + this.snippet_author.toXML() + this.object_id.toXML() + "<unread>" + this.unread + "</unread>";
    }
}