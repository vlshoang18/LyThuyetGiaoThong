package com.example.lythuyetgiaothong.models;

public class ItemLearnModel {
    int imglearn;
    String tvlearn;

    public ItemLearnModel(int imglearn, String tvlearn) {
        this.imglearn = imglearn;
        this.tvlearn = tvlearn;
    }

    public int getImglearn() {
        return imglearn;
    }

    public void setImglearn(int imglearn) {
        this.imglearn = imglearn;
    }

    public String getTvlearn() {
        return tvlearn;
    }

    public void setTvlearn(String tvlearn) {
        this.tvlearn = tvlearn;
    }
}
