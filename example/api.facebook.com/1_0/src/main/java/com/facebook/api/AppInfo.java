package com.facebook.api;


class AppInfo  {


    private Long app_id;
    private String api_key;
    private String canvas_name;
    private String display_name;
    private String icon_url;
    private String logo_url;
    private String company_name;
    private String description;
    private Integer daily_active_users;
    private Integer weekly_active_users;
    private Integer monthly_active_users;
    private String category;
    private String subcategory;


    public void setAppId(Long app_id) {
        this.app_id = app_id;
    }

    public Long getAppId() {
        return this.app_id;
    }
    public void setApiKey(String api_key) {
        this.api_key = api_key;
    }

    public String getApiKey() {
        return this.api_key;
    }
    public void setCanvasName(String canvas_name) {
        this.canvas_name = canvas_name;
    }

    public String getCanvasName() {
        return this.canvas_name;
    }
    public void setDisplayName(String display_name) {
        this.display_name = display_name;
    }

    public String getDisplayName() {
        return this.display_name;
    }
    public void setIconUrl(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getIconUrl() {
        return this.icon_url;
    }
    public void setLogoUrl(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getLogoUrl() {
        return this.logo_url;
    }
    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    public String getCompanyName() {
        return this.company_name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDailyActiveUsers(Integer daily_active_users) {
        this.daily_active_users = daily_active_users;
    }

    public Integer getDailyActiveUsers() {
        return this.daily_active_users;
    }
    public void setWeeklyActiveUsers(Integer weekly_active_users) {
        this.weekly_active_users = weekly_active_users;
    }

    public Integer getWeeklyActiveUsers() {
        return this.weekly_active_users;
    }
    public void setMonthlyActiveUsers(Integer monthly_active_users) {
        this.monthly_active_users = monthly_active_users;
    }

    public Integer getMonthlyActiveUsers() {
        return this.monthly_active_users;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getSubcategory() {
        return this.subcategory;
    }

    public String toXML() {
        return "<app_id>" + this.app_id + "</app_id>" + "<api_key>" + this.api_key + "</api_key>" + "<canvas_name>" + this.canvas_name + "</canvas_name>" + "<display_name>" + this.display_name + "</display_name>" + "<icon_url>" + this.icon_url + "</icon_url>" + "<logo_url>" + this.logo_url + "</logo_url>" + "<company_name>" + this.company_name + "</company_name>" + "<description>" + this.description + "</description>" + "<daily_active_users>" + this.daily_active_users + "</daily_active_users>" + "<weekly_active_users>" + this.weekly_active_users + "</weekly_active_users>" + "<monthly_active_users>" + this.monthly_active_users + "</monthly_active_users>" + "<category>" + this.category + "</category>" + "<subcategory>" + this.subcategory + "</subcategory>";
    }
}