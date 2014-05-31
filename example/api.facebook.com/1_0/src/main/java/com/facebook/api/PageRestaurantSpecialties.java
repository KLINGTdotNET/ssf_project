package com.facebook.api;


class PageRestaurantSpecialties  {


    private Boolean breakfast;
    private Boolean lunch;
    private Boolean dinner;
    private Boolean coffee;
    private Boolean drinks;


    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public Boolean getBreakfast() {
        return this.breakfast;
    }
    public void setLunch(Boolean lunch) {
        this.lunch = lunch;
    }

    public Boolean getLunch() {
        return this.lunch;
    }
    public void setDinner(Boolean dinner) {
        this.dinner = dinner;
    }

    public Boolean getDinner() {
        return this.dinner;
    }
    public void setCoffee(Boolean coffee) {
        this.coffee = coffee;
    }

    public Boolean getCoffee() {
        return this.coffee;
    }
    public void setDrinks(Boolean drinks) {
        this.drinks = drinks;
    }

    public Boolean getDrinks() {
        return this.drinks;
    }

    public String toXML() {
        return "<breakfast>" + this.breakfast + "</breakfast>" + "<lunch>" + this.lunch + "</lunch>" + "<dinner>" + this.dinner + "</dinner>" + "<coffee>" + this.coffee + "</coffee>" + "<drinks>" + this.drinks + "</drinks>";
    }
}