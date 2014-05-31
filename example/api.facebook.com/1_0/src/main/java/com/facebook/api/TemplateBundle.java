package com.facebook.api;

import com.facebook.api.FullStoryTemplate;
import com.facebook.api.Tbid;
import com.facebook.api.Time;

class TemplateBundle  {


    private FullStoryTemplate full_story_template;
    private Time time_created;
    private Tbid template_bundle_id;


    public void setFullStoryTemplate(FullStoryTemplate full_story_template) {
        this.full_story_template = full_story_template;
    }

    public FullStoryTemplate getFullStoryTemplate() {
        return this.full_story_template;
    }
    public void setTimeCreated(Time time_created) {
        this.time_created = time_created;
    }

    public Time getTimeCreated() {
        return this.time_created;
    }
    public void setTemplateBundleId(Tbid template_bundle_id) {
        this.template_bundle_id = template_bundle_id;
    }

    public Tbid getTemplateBundleId() {
        return this.template_bundle_id;
    }

    public String toXML() {
        return this.full_story_template.toXML() + this.time_created.toXML() + this.template_bundle_id.toXML();
    }
}