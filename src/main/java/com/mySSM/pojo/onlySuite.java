package com.mySSM.pojo;

import com.mySSM.Utils.DateUtil;

public class onlySuite {
    private int id;
    private boolean only;
    private String date;

    public onlySuite() {
    }

    public onlySuite(int id) {
        this.id = id;
        only = false;
        date = DateUtil.getNowDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOnly() {
        return only;
    }

    public void setOnly(boolean only) {
        this.only = only;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "onlySuite{" +
                "id=" + id +
                ", only=" + only +
                ", date='" + date + '\'' +
                '}';
    }
}
