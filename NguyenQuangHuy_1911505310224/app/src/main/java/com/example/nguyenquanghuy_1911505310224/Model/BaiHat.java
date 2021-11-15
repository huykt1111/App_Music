package com.example.nguyenquanghuy_1911505310224.Model;

public class BaiHat {
    public String tenbaihat;
    public String tgbaihat;
    public int baihat;

    public BaiHat(String tenbaihat, String tgbaihat, int baihat) {
        this.tenbaihat = tenbaihat;
        this.tgbaihat = tgbaihat;
        this.baihat = baihat;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getTgbaihat() {
        return tgbaihat;
    }

    public void setTgbaihat(String tgbaihat) {
        this.tgbaihat = tgbaihat;
    }

    public int getBaihat() {
        return baihat;
    }

    public void setBaihat(int baihat) {
        this.baihat = baihat;
    }
}
