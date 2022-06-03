package com.example.lythuyetgiaothong.models;

public class ItemLuatModel {
    int imgluat;
    String tvluat;

    public ItemLuatModel(int imgluat, String tvluat) {
        this.imgluat = imgluat;
        this.tvluat = tvluat;
    }

    public int getImgluat() {
        return imgluat;
    }

    public void setImgluat(int imgluat) {
        this.imgluat = imgluat;
    }

    public String getTvluat() {
        return tvluat;
    }

    public void setTvluat(String tvluat) {
        this.tvluat = tvluat;
    }
}
