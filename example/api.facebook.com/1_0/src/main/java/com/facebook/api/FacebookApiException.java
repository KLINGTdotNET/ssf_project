package com.facebook.api;

import com.facebook.api.JsonString;
import com.facebook.api.FacebookApiErrorCode;

class FacebookApiException  {


    private FacebookApiErrorCode error_code;
    private String error_msg;
    private JsonString error_data;


    public void setErrorCode(FacebookApiErrorCode error_code) {
        this.error_code = error_code;
    }

    public FacebookApiErrorCode getErrorCode() {
        return this.error_code;
    }
    public void setErrorMsg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getErrorMsg() {
        return this.error_msg;
    }
    public void setErrorData(JsonString error_data) {
        this.error_data = error_data;
    }

    public JsonString getErrorData() {
        return this.error_data;
    }

    public String toXML() {
        return this.error_code.toXML() + "<error_msg>" + this.error_msg + "</error_msg>" + this.error_data.toXML();
    }
}