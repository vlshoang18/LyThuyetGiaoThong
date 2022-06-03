package com.example.lythuyetgiaothong.models;

public class ItemHomeModel {
    int imghome;
    String tvhome;

    public ItemHomeModel(int imghome, String tvhome) {
        this.imghome = imghome;
        this.tvhome = tvhome;
    }

    public int getImghome() {
        return imghome;
    }

    public void setImghome(int imghome) {
        this.imghome = imghome;
    }

    public String getTvhome() {
        return tvhome;
    }

    public void setTvhome(String tvhome) {
        this.tvhome = tvhome;
    }
}

