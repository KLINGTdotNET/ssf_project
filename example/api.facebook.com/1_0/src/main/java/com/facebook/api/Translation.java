package com.facebook.api;


class Translation  {


    private String native_string;
    private String description;
    private String native_hash;
    private String translation;
    private String locale;
    private String approval_status;
    private String pre_hash_string;
    private String best_string;
    private Integer is_translatable;


    public void setNativeString(String native_string) {
        this.native_string = native_string;
    }

    public String getNativeString() {
        return this.native_string;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setNativeHash(String native_hash) {
        this.native_hash = native_hash;
    }

    public String getNativeHash() {
        return this.native_hash;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return this.translation;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocale() {
        return this.locale;
    }
    public void setApprovalStatus(String approval_status) {
        this.approval_status = approval_status;
    }

    public String getApprovalStatus() {
        return this.approval_status;
    }
    public void setPreHashString(String pre_hash_string) {
        this.pre_hash_string = pre_hash_string;
    }

    public String getPreHashString() {
        return this.pre_hash_string;
    }
    public void setBestString(String best_string) {
        this.best_string = best_string;
    }

    public String getBestString() {
        return this.best_string;
    }
    public void setIsTranslatable(Integer is_translatable) {
        this.is_translatable = is_translatable;
    }

    public Integer getIsTranslatable() {
        return this.is_translatable;
    }

    public String toXML() {
        return "<native_string>" + this.native_string + "</native_string>" + "<description>" + this.description + "</description>" + "<native_hash>" + this.native_hash + "</native_hash>" + "<translation>" + this.translation + "</translation>" + "<locale>" + this.locale + "</locale>" + "<approval_status>" + this.approval_status + "</approval_status>" + "<pre_hash_string>" + this.pre_hash_string + "</pre_hash_string>" + "<best_string>" + this.best_string + "</best_string>" + "<is_translatable>" + this.is_translatable + "</is_translatable>";
    }
}