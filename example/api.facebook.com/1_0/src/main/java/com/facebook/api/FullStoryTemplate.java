package com.facebook.api;


class FullStoryTemplate  {


    private String template_title;
    private String template_body;


    public void setTemplateTitle(String template_title) {
        this.template_title = template_title;
    }

    public String getTemplateTitle() {
        return this.template_title;
    }
    public void setTemplateBody(String template_body) {
        this.template_body = template_body;
    }

    public String getTemplateBody() {
        return this.template_body;
    }

    public String toXML() {
        return "<template_title>" + this.template_title + "</template_title>" + "<template_body>" + this.template_body + "</template_body>";
    }
}