package com.mySSM.pojo;

import com.mySSM.Utils.DateUtil;

import java.util.Objects;

public class onlyCode {
    private int id;
    private boolean only;
    private String date;

    public onlyCode(int id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        onlyCode onlyCode = (onlyCode) o;
        return id == onlyCode.id && only == onlyCode.only && date.equals(onlyCode.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, only, date);
    }

    @Override
    public String toString() {
        return "onlyCode{" +
                "id=" + id +
                ", only=" + only +
                ", date='" + date + '\'' +
                '}';
    }
}
