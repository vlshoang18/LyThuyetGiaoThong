package com.example.lythuyetgiaothong.models;

public class ItemThiModel {
    int img_thi;
    String tv_thi;

    public ItemThiModel(int img_thi, String tv_thi) {
        this.img_thi = img_thi;
        this.tv_thi = tv_thi;
    }

    public int getImg_thi() {
        return img_thi;
    }

    public void setImg_thi(int img_thi) {
        this.img_thi = img_thi;
    }

    public String getTv_thi() {
        return tv_thi;
    }

    public void setTv_thi(String tv_thi) {
        this.tv_thi = tv_thi;
    }
}