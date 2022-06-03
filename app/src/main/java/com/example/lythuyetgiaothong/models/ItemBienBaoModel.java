package com.example.lythuyetgiaothong.models;

public class ItemBienBaoModel {
    int img_bienbao;
    String tv_bienbao1;
    String tv_bienbao2;

    public ItemBienBaoModel(int img_bienbao, String tv_bienbao1, String tv_bienbao2) {
        this.img_bienbao = img_bienbao;
        this.tv_bienbao1 = tv_bienbao1;
        this.tv_bienbao2 = tv_bienbao2;
    }

    public int getImg_bienbao() {
        return img_bienbao;
    }

    public void setImg_bienbao(int img_bienbao) {
        this.img_bienbao = img_bienbao;
    }

    public String getTv_bienbao1() {
        return tv_bienbao1;
    }

    public void setTv_bienbao1(String tv_bienbao1) {
        this.tv_bienbao1 = tv_bienbao1;
    }

    public String getTv_bienbao2() {
        return tv_bienbao2;
    }

    public void setTv_bienbao2(String tv_bienbao2) {
        this.tv_bienbao2 = tv_bienbao2;
    }
}
