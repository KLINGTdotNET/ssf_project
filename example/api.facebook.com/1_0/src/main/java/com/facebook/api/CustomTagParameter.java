package com.facebook.api;


class CustomTagParameter  {


    private String name;
    private String custom_tag_parameter_type;
    private String description;
    private String default_value;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setCustomTagParameterType(String custom_tag_parameter_type) {
        this.custom_tag_parameter_type = custom_tag_parameter_type;
    }

    public String getCustomTagParameterType() {
        return this.custom_tag_parameter_type;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDefaultValue(String default_value) {
        this.default_value = default_value;
    }

    public String getDefaultValue() {
        return this.default_value;
    }

    public String toXML() {
        return "<name>" + this.name + "</name>" + "<custom_tag_parameter_type>" + this.custom_tag_parameter_type + "</custom_tag_parameter_type>" + "<description>" + this.description + "</description>" + "<default_value>" + this.default_value + "</default_value>";
    }
}