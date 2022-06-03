package com.example.lythuyetgiaothong.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignCategoryModel {
    @SerializedName("image")
    @Expose
    private SignImage_1Model image;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public SignImage_1Model getImage() {
        return image;
    }

    public void setImage(SignImage_1Model image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
