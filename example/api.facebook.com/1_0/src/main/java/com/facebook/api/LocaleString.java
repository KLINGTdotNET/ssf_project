package com.facebook.api;


class LocaleString  {


    private String native_string;


    public void setNativeString(String native_string) {
        this.native_string = native_string;
    }

    public String getNativeString() {
        return this.native_string;
    }

    public String toXML() {
        return "<native_string>" + this.native_string + "</native_string>";
    }
}