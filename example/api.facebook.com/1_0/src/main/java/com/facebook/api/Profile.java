/**
 * This code was generated by the xsdtocls codegenerator and is not intended to be changed manually!
 * Note that all your changes will be lost if the codegenerator runs another time on the same destination directory!
 * For further information take a look at: https://github.com/KLINGTdotNET/ssf_project
 */

package com.facebook.api;


class Profile  {


    private Long id;
    private String url;
    private String name;
    private String pic_square;
    private String type;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setPicSquare(String pic_square) {
        this.pic_square = pic_square;
    }

    public String getPicSquare() {
        return this.pic_square;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String toXML() {
        return "<id>" + this.id + "</id>" + "<url>" + this.url + "</url>" + "<name>" + this.name + "</name>" + "<pic_square>" + this.pic_square + "</pic_square>" + "<type>" + this.type + "</type>";
    }
}