package com.facebook.api;

import com.facebook.api.Time;

class PageHours  {


    private Time mon_1_open;
    private Time mon_1_close;
    private Time tue_1_open;
    private Time tue_1_close;
    private Time wed_1_open;
    private Time thu_1_open;
    private Time thu_1_close;
    private Time fri_1_open;
    private Time fri_1_close;
    private Time sat_1_open;
    private Time sat_1_close;
    private Time sun_1_open;
    private Time sun_1_close;
    private Time mon_2_open;
    private Time mon_2_close;
    private Time tue_2_open;
    private Time tue_2_close;
    private Time wed_2_open;
    private Time wed_2_close;
    private Time thu_2_open;
    private Time thu_2_close;
    private Time fri_2_open;
    private Time fri_2_close;
    private Time sat_2_open;
    private Time sat_2_close;
    private Time sun_2_open;
    private Time sun_2_close;


    public void setMon1Open(Time mon_1_open) {
        this.mon_1_open = mon_1_open;
    }

    public Time getMon1Open() {
        return this.mon_1_open;
    }
    public void setMon1Close(Time mon_1_close) {
        this.mon_1_close = mon_1_close;
    }

    public Time getMon1Close() {
        return this.mon_1_close;
    }
    public void setTue1Open(Time tue_1_open) {
        this.tue_1_open = tue_1_open;
    }

    public Time getTue1Open() {
        return this.tue_1_open;
    }
    public void setTue1Close(Time tue_1_close) {
        this.tue_1_close = tue_1_close;
    }

    public Time getTue1Close() {
        return this.tue_1_close;
    }
    public void setWed1Open(Time wed_1_open) {
        this.wed_1_open = wed_1_open;
    }

    public Time getWed1Open() {
        return this.wed_1_open;
    }
    public void setThu1Open(Time thu_1_open) {
        this.thu_1_open = thu_1_open;
    }

    public Time getThu1Open() {
        return this.thu_1_open;
    }
    public void setThu1Close(Time thu_1_close) {
        this.thu_1_close = thu_1_close;
    }

    public Time getThu1Close() {
        return this.thu_1_close;
    }
    public void setFri1Open(Time fri_1_open) {
        this.fri_1_open = fri_1_open;
    }

    public Time getFri1Open() {
        return this.fri_1_open;
    }
    public void setFri1Close(Time fri_1_close) {
        this.fri_1_close = fri_1_close;
    }

    public Time getFri1Close() {
        return this.fri_1_close;
    }
    public void setSat1Open(Time sat_1_open) {
        this.sat_1_open = sat_1_open;
    }

    public Time getSat1Open() {
        return this.sat_1_open;
    }
    public void setSat1Close(Time sat_1_close) {
        this.sat_1_close = sat_1_close;
    }

    public Time getSat1Close() {
        return this.sat_1_close;
    }
    public void setSun1Open(Time sun_1_open) {
        this.sun_1_open = sun_1_open;
    }

    public Time getSun1Open() {
        return this.sun_1_open;
    }
    public void setSun1Close(Time sun_1_close) {
        this.sun_1_close = sun_1_close;
    }

    public Time getSun1Close() {
        return this.sun_1_close;
    }
    public void setMon2Open(Time mon_2_open) {
        this.mon_2_open = mon_2_open;
    }

    public Time getMon2Open() {
        return this.mon_2_open;
    }
    public void setMon2Close(Time mon_2_close) {
        this.mon_2_close = mon_2_close;
    }

    public Time getMon2Close() {
        return this.mon_2_close;
    }
    public void setTue2Open(Time tue_2_open) {
        this.tue_2_open = tue_2_open;
    }

    public Time getTue2Open() {
        return this.tue_2_open;
    }
    public void setTue2Close(Time tue_2_close) {
        this.tue_2_close = tue_2_close;
    }

    public Time getTue2Close() {
        return this.tue_2_close;
    }
    public void setWed2Open(Time wed_2_open) {
        this.wed_2_open = wed_2_open;
    }

    public Time getWed2Open() {
        return this.wed_2_open;
    }
    public void setWed2Close(Time wed_2_close) {
        this.wed_2_close = wed_2_close;
    }

    public Time getWed2Close() {
        return this.wed_2_close;
    }
    public void setThu2Open(Time thu_2_open) {
        this.thu_2_open = thu_2_open;
    }

    public Time getThu2Open() {
        return this.thu_2_open;
    }
    public void setThu2Close(Time thu_2_close) {
        this.thu_2_close = thu_2_close;
    }

    public Time getThu2Close() {
        return this.thu_2_close;
    }
    public void setFri2Open(Time fri_2_open) {
        this.fri_2_open = fri_2_open;
    }

    public Time getFri2Open() {
        return this.fri_2_open;
    }
    public void setFri2Close(Time fri_2_close) {
        this.fri_2_close = fri_2_close;
    }

    public Time getFri2Close() {
        return this.fri_2_close;
    }
    public void setSat2Open(Time sat_2_open) {
        this.sat_2_open = sat_2_open;
    }

    public Time getSat2Open() {
        return this.sat_2_open;
    }
    public void setSat2Close(Time sat_2_close) {
        this.sat_2_close = sat_2_close;
    }

    public Time getSat2Close() {
        return this.sat_2_close;
    }
    public void setSun2Open(Time sun_2_open) {
        this.sun_2_open = sun_2_open;
    }

    public Time getSun2Open() {
        return this.sun_2_open;
    }
    public void setSun2Close(Time sun_2_close) {
        this.sun_2_close = sun_2_close;
    }

    public Time getSun2Close() {
        return this.sun_2_close;
    }

    public String toXML() {
        return this.mon_1_open.toXML() + this.mon_1_close.toXML() + this.tue_1_open.toXML() + this.tue_1_close.toXML() + this.wed_1_open.toXML() + this.thu_1_open.toXML() + this.thu_1_close.toXML() + this.fri_1_open.toXML() + this.fri_1_close.toXML() + this.sat_1_open.toXML() + this.sat_1_close.toXML() + this.sun_1_open.toXML() + this.sun_1_close.toXML() + this.mon_2_open.toXML() + this.mon_2_close.toXML() + this.tue_2_open.toXML() + this.tue_2_close.toXML() + this.wed_2_open.toXML() + this.wed_2_close.toXML() + this.thu_2_open.toXML() + this.thu_2_close.toXML() + this.fri_2_open.toXML() + this.fri_2_close.toXML() + this.sat_2_open.toXML() + this.sat_2_close.toXML() + this.sun_2_open.toXML() + this.sun_2_close.toXML();
    }
}